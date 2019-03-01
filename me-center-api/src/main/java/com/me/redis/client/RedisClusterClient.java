package com.me.redis.client;


import com.me.redis.exception.RedisException;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <Description> 集群版redis客户端<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/9/1 <br>
 */
public class RedisClusterClient implements IRedisClient {
    /**
     * 逗号
     */
    private static final String COMMA;
    /**
     * 冒号
     */
    private static final String COLON;

    public static final Integer maxAttempts;

    static {
        COMMA = ",";
        COLON = ":";
        maxAttempts = 5;
    }

    /**
     * The Logger.
     */
    private Logger logger = LoggerFactory.getLogger(RedisClusterClient.class);
    /**
     * jedisCluster
     */
    private JedisCluster jedisCluster;

    /**
     * 构造
     *
     * @param redisProperties redisProperties
     */
    public RedisClusterClient(RedisProperties redisProperties) {
        // 第一步：使用JedisCluster对象。需要一个Set<HostAndPort>参数。Redis节点的列表。
        Set<HostAndPort> nodes = new HashSet<>();
        List<String> connectString = redisProperties.getCluster().getNodes();
        if (connectString.size()<=0) {
            logger.error("redis cluster ip addresses and ports can't be empty.");
            return;
        }
        for (String connectInfo:connectString){
            String[] ci = connectInfo.split(COLON);
            HostAndPort hostAndPort = new HostAndPort(ci[0],Integer.parseInt(ci[1]));
            nodes.add(hostAndPort);
        }
        int soTimeout = redisProperties.getTimeout();

        RedisProperties.Pool pool = redisProperties.getPool();
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        if (pool!=null){
            poolConfig.setMaxIdle(pool.getMaxIdle());
            poolConfig.setMaxTotal(pool.getMaxActive()+pool.getMaxWait());
            poolConfig.setMinIdle(pool.getMinIdle());
        }
        int connectionTimeout = 30000;// 写死连接redis超时时间为30秒
//TODO        String password = redisProperties.getPassword();
//redis服务器没有设置密码就不需要在启动redis客户端的时候给服务器发送Auth验证，否则报错，也就是这里不需要传password到jedisCluster构造方法中。
        jedisCluster = new JedisCluster(nodes, connectionTimeout, soTimeout, maxAttempts, poolConfig);
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        return jedisCluster.set(key, value, nxxx, expx, time);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return jedisCluster.exists(key);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedisCluster.expire(key, seconds);
    }

    @Override
    public Long del(String key) {
        return jedisCluster.del(key);
    }

    @Override
    public String hget(String key, String field) {
        return jedisCluster.hget(key, field);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value);
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return jedisCluster.hgetAll(key);
    }

    @Override
    public void close() {
        try {
            jedisCluster.close();
        } catch (IOException e) {
            logger.error("close redis Cluster failed.", e);
        }
    }
}
