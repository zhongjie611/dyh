package com.bdqn.fastweixin.api.response;

/**
 * <p>根据code换取access_token.</p>
 *
 * @version 
 * @author dongdh
 * @date 2015年7月17日
 *
 */
public class GetPageCodeTokenResponse {

	private String accessToken;
	
	private int expiresIn;
	
	private String openid;
	
	private String scope;
	
	private String unionid;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}
