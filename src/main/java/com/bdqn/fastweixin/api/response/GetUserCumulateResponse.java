package com.bdqn.fastweixin.api.response;

import com.bdqn.fastweixin.api.entity.UserCumulate;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserCumulateResponse extends BaseResponse {

    private List<UserCumulate> list;

    public List<UserCumulate> getList() {
        return list;
    }

    public void setList(List<UserCumulate> list) {
        this.list = list;
    }
}
