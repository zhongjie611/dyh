package com.bdqn.module;

import java.util.List;

/**
 * Created by Administrator on 2019-07-18.
 */
public class ResponseVueStL {
    private Integer status = 0;
    private List message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List getMessage() {
        return message;
    }

    public void setMessage(List message) {
        this.message = message;
    }
}
