package com.bdqn.fastweixin.api.response;

import com.bdqn.fastweixin.api.entity.UserRead;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserReadResponse extends BaseResponse {

    private List<UserRead> list;

    public List<UserRead> getList() {
        return list;
    }

    public void setList(List<UserRead> list) {
        this.list = list;
    }
}
