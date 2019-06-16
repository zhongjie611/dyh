package com.bdqn.fastweixin.message.req;

import java.util.HashMap;
import java.util.Map;

public class BaseEvent extends BaseReq {

    private String event;
    
    private Map<String, String> reqMap = new HashMap<String, String>();

    public BaseEvent() {
        setMsgType(ReqType.EVENT);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

	public Map<String, String> getReqMap() {
		return reqMap;
	}

	public void setReqMap(Map<String, String> reqMap) {
		this.reqMap = reqMap;
	}
}
