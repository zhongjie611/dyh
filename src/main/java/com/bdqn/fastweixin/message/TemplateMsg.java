package com.bdqn.fastweixin.message;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>.</p>
 *
 * @version 
 * @author dongdh
 * @date 2015年6月30日
 *
 */
public class TemplateMsg {

	private String touser;
	
	private String template_id;
	
	private String url;
	
	/**该字段微信高版本已经去除了，但是低版本仍然有效果..不知道为什么要去除**/
	private String topcolor;
	
	private Map<String, TemplateData> data;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopcolor() {
		return topcolor;
	}

	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}

	public Map<String, TemplateData> getData() {
		return data;
	}

	public void setData(Map<String, TemplateData> data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		TemplateMsg msg = new TemplateMsg();
		msg.setTemplate_id("dddd");
		msg.setTopcolor("#ffffff");
		msg.setTouser("alsjflkasddjflfasj");
		msg.setUrl("http://www.baidu.com");
		
		
		Map<String, TemplateData> aa = new HashMap<String, TemplateData>();
		
		TemplateData d1 = new TemplateData();
		d1.setColor("aaa");
		d1.setValue("vv");
		aa.put("first", d1);
		
		TemplateData d2 = new TemplateData();
		d2.setColor("aaa22");
		d2.setValue("vv222");
		aa.put("keynote1", d2);
		
		msg.setData(aa);;
		
		String s = JSONObject.toJSONString(msg);
		System.out.println(s);
	}
}
