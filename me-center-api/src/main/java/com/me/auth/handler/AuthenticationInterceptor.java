package com.me.auth.handler;

import com.me.auth.annotation.SkipAuthentication;
import com.me.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;

/**
 * 拦截器实现类
 * 1,校验用户的登陆信息是否正确
 *
 * @author zhaohaojie
 * @date 2019-01-12 10:10
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    public static final String USER_EMAIL = "UserName";
    public static final String ENCRYPTION_KEY = "EncryptKey";
    //用户信息服务类
    private UserInfoService userInfoService;

    public AuthenticationInterceptor(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 拦截请求并校验 邮箱和加密串匹配度
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (isSkipAuthenticate((HandlerMethod) handler)) {
            return super.preHandle(request, response, handler);
        }
        // 邮箱和加密串
        String userEmail = request.getHeader(USER_EMAIL);
        String encryptKey = request.getHeader(ENCRYPTION_KEY);

        // TODO 做相应的二次处理，将加密串解密
        // 将手机号对应的 ip 存入 session中，表示登陆中，
        HttpSession session = request.getSession();

        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String result = (String) stringRedisTemplate.opsForHash().get("IP_Bound_Session", userEmail + hostAddress);
        if (result == null) {
            stringRedisTemplate.opsForHash().put("IP_Bound_Session", userEmail + hostAddress, session.getId());
        }

        // 这里直接调用controller层
        return super.preHandle(request, response, handler);
    }

    public boolean isSkipAuthenticate(HandlerMethod handler) {
        if (handler.hasMethodAnnotation(SkipAuthentication.class)) {
            return handler.getMethodAnnotation(SkipAuthentication.class).value();
        } else if (handler.getMethod().getDeclaringClass().isAnnotationPresent(SkipAuthentication.class)) {
            return true;
        }
        return false;
    }
}

