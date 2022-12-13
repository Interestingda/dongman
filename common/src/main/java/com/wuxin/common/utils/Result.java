package com.wuxin.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Atothor:aa
 * data:2022/10/13
 */
@NoArgsConstructor
public class Result {
    private Integer code;
    private String token;
    private Object data;
    private String message;

    public Result(Object data) {
        this.data = data;
    }

    public Result(Integer code, String message, String token) {
        this.code = code;
        this.token = token;
        this.message = message;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static Result success(Object data) {
        System.out.println(new Result(200, data, "success"));
        return new Result(200, data, "success");
    }

    public static Result success(Integer code, Object data, String message) {
        return new Result(200, data, "success");
    }

    public static Result success(Integer code, String message, String token) {
        return new Result(code, message, token);
    }

    public static Result success(Integer code, String message) {
        return new Result(code, message);
    }

    public static Result fail(Integer code, String message) {
        return new Result(code, message);
    }

    public static Result data(Object data) {

        return new Result(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
