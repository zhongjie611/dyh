package com.bdqn.fastweixin.api.response;

import com.bdqn.fastweixin.api.entity.UserShare;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserShareResponse extends BaseResponse {

    private List<UserShare> list;

    public List<UserShare> getList() {
        return list;
    }

    public void setList(List<UserShare> list) {
        this.list = list;
    }
}
