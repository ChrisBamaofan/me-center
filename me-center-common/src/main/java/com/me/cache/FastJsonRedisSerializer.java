package com.me.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * fastjson序列化
 *
 * @author zhaohaojie
 * @date 2019-02-27 12:38
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    private static final String Default_Charset = "UTF-8";

    private Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        try {
            return JSONObject.toJSONString(t, SerializerFeature.WriteDateUseDateFormat).getBytes(Default_Charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return new byte[0];
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length < 0) {
            return null;
        }
        try {
            String var1 = new String(bytes,Default_Charset);
            return JSON.parseObject(var1,clazz);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

