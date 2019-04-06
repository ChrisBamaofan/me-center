package com.me.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohaojie
 * @date 2019-04-06 11:51
 */
public class MQException extends RuntimeException {

    private Integer errorCode=0;
    private String errorMessage;
    private Map<String,String> map=new HashMap<String,String>();

    public MQException(String message){
        this.errorCode = -1;
        this.errorMessage = message;
    }

    public MQException(Integer code,String message){
        this.errorCode = code;
        this.errorMessage = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    /**
     * 设置异常补充信息
     * @param key
     * @param value
     * @return
     */
    public MQException set(String key,String value) {
        if (key == null || value == null){
            return this;
        }
        if (map == null){
            this.map = new HashMap<>();
        }
        map.put(key,value);
        return this;
    }
    /**
     * 如果有异常就需要包装为统一异常
     * @param ex
     * @return
     */
    public MQException wrap(Exception ex){
        if (ex instanceof RuntimeException){
            return (MQException)ex;
        }else{
            return new MQException(ex.getMessage());
        }
    }

    public String getMessage(){
        StringBuilder builder = new StringBuilder();
        builder.append(errorMessage).append(" (").append(errorCode).append(")");
        if (map != null){
            for (Map.Entry entry : map.entrySet()){
                builder.append("\n\t").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.print("1");
        System.out.print("\t2");
        System.out.print("\n3");
        System.out.print("\n\t4");
        System.out.println();
        System.out.print("\t\n5");        System.out.print("\t\n6");

    }
}

