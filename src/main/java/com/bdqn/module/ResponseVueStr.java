package com.bdqn.module;

/**
 * Created by Administrator on 2019-07-18.
 */
public class ResponseVueStr {
    private Integer status = 0;
    private String message = "成功";

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
