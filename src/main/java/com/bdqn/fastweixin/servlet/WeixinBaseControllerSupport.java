package com.bdqn.fastweixin.servlet;

import com.bdqn.fastweixin.api.config.ApiConfig;
import com.bdqn.fastweixin.message.BaseMsg;
import com.bdqn.fastweixin.message.req.TextReqMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/8.
 */
@Controller
public class WeixinBaseControllerSupport extends WeixinControllerSupport{

    public static final Logger log = LoggerFactory.getLogger(WeixinBaseControllerSupport.class);

    @Autowired
    private ApiConfig apiConfig;

    @Override
    protected String getToken() {
        return apiConfig.getToken();
    }

    @Override
    protected String getAppId() {
        return apiConfig.getAppid();
    }

    @Override
    protected String getAESKey() {
        return null;
    }

    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        log.debug("用户发送到服务器的内容:{}", content);
        return null;
    }

    public ApiConfig getApiConfig(){
        return this.apiConfig;
    }

}
