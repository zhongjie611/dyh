package com.bdqn.service;

import com.bdqn.fastweixin.api.BaseAPI;
import com.bdqn.fastweixin.api.config.ApiConfig;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/28.
 */
public class UpdateAccessTokenApi extends BaseAPI {

    public UpdateAccessTokenApi(ApiConfig config) {
        super(config);
    }
    public void refreshToken(){
        super.refreshToken();
    }
}
