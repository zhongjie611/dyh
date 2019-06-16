package com.bdqn.fastweixin.api;

import java.util.Date;

import com.bdqn.fastweixin.api.config.ApiConfig;
import com.bdqn.fastweixin.api.response.BaseResponse;
import com.bdqn.fastweixin.message.TemplateMsg;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;

/**
 * <p>.</p>
 *
 * @version 
 * @author dongdh
 * @date 2015年6月30日
 *
 */
public class TemplateAPI extends BaseAPI {

	private static final Log LOG = LogFactory.getLog(TemplateAPI.class);
	
	public TemplateAPI(ApiConfig config) {
		super(config);
	}

	public BaseResponse sendTemplateMessage(TemplateMsg msg) {
		//https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
		
		String url = BASE_API_URL + "cgi-bin/message/template/send?access_token=#";
		LOG.debug("发送模板消息..." + new Date());
		return executePost(url, JSON.toJSONString(msg));
	}
}
