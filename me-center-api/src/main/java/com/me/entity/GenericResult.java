package com.me.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohaojie
 * @date 2019-04-18 16:15
 */
public class GenericResult<T> {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;
    private Map<String, Object> extraProperties = new HashMap();

    public static <T> GenericResult<T> success(T data) {
        return build(0, "", data);
    }

    public static <T> GenericResult<T> failure(Integer code, String message) {
        return build(code, message, null);
    }

    public static <T> GenericResult<T> failure(Integer code, String message, T data) {
        return build(code, message, data);
    }

    public static <T> GenericResult<T> build(Integer code, String message, T data) {
        return new GenericResult(code, message, data);
    }

    public GenericResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getExtraProperties() {
        return this.extraProperties;
    }

    public void setExtraProperties(Map<String, Object> extraProperties) {
        this.extraProperties = extraProperties;
    }

    public GenericResult<T> extra(String name, Object value) {
        this.extraProperties.put(name, value);
        return this;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }
}

