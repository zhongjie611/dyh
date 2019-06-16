package com.bdqn.fastweixin.api;

import com.bdqn.fastweixin.api.config.ApiConfig;
import com.bdqn.fastweixin.api.response.BaseResponse;
import com.bdqn.fastweixin.api.response.GetPageCodeTokenResponse;
import com.bdqn.fastweixin.util.BeanUtil;
import com.bdqn.fastweixin.util.JSONUtil;
import com.bdqn.fastweixin.util.NetWorkCenter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>.</p>
 *
 * @version 
 * @author dongdh
 * @date 2015年7月17日
 *
 */
public class PageAccessAPI extends BaseAPI {

	private static final Log LOG = LogFactory.getLog(PageAccessAPI.class);

    public PageAccessAPI(ApiConfig config) {
        super(config);
    }
	
    
    public GetPageCodeTokenResponse getPageCodeToken(String code) {
    	BeanUtil.requireNonNull(code, "openid is null");
    	GetPageCodeTokenResponse response = null;
    	String url = BASE_API_URL +  "sns/oauth2/access_token?appid="
    	+ config.getAppid()
    	+ "&secret=" + config.getSecret()
    	+ "&code=" + code
    	+ "&grant_type=authorization_code";
    	BaseResponse r = NetWorkCenter.get(url);
    	String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, GetPageCodeTokenResponse.class);
    	
        return response;
    }
    
}
