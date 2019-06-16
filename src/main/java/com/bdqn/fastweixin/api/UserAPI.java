package com.bdqn.fastweixin.api;

import java.util.HashMap;
import java.util.Map;

import com.bdqn.fastweixin.api.response.BaseResponse;
import com.bdqn.fastweixin.api.response.CreateGroupResponse;
import com.bdqn.fastweixin.util.BeanUtil;
import com.bdqn.fastweixin.util.JSONUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bdqn.fastweixin.api.config.ApiConfig;
import com.bdqn.fastweixin.api.enums.ResultType;
import com.bdqn.fastweixin.api.response.GetGroupsResponse;
import com.bdqn.fastweixin.api.response.GetUserInfoResponse;
import com.bdqn.fastweixin.api.response.GetUsersResponse;
import com.bdqn.fastweixin.util.StrUtil;

/**
 * 用户管理相关API
 *
 * @author peiyu
 * @since 1.2
 */
public class UserAPI extends BaseAPI {

    private static final Log LOG = LogFactory.getLog(UserAPI.class);

    public UserAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 获取关注者列表
     *
     * @param nextOpenid 下一个用户的ID
     * @return 关注者列表对象
     */
    public GetUsersResponse getUsers(String nextOpenid) {
        GetUsersResponse response = null;
        LOG.debug("获取关注者列表.....");
        String url = BASE_API_URL + "cgi-bin/user/get?access_token=#";
        if (StrUtil.isNotBlank(nextOpenid)) {
            url += "&next_openid=" + nextOpenid;
        }
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, GetUsersResponse.class);
        return response;
    }

    /**
     * 设置关注者备注
     *
     * @param openid 关注者ID
     * @param remark 备注内容
     * @return 调用结果
     */
    public ResultType setUserRemark(String openid, String remark) {
        BeanUtil.requireNonNull(openid, "openid is null");
        LOG.debug("设置关注者备注.....");
        String url = BASE_API_URL + "cgi-bin/user/info/updateremark?access_token=#";
        Map<String, String> param = new HashMap<String, String>();
        param.put("openid", openid);
        param.put("remark", remark);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 创建分组
     *
     * @param name 分组名称
     * @return 返回对象，包含分组的ID和名称信息
     */
    public CreateGroupResponse createGroup(String name) {
        CreateGroupResponse response = null;
        BeanUtil.requireNonNull(name, "name is null");
        LOG.debug("创建分组.....");
        String url = BASE_API_URL + "cgi-bin/groups/create?access_token=#";
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> group = new HashMap<String, Object>();
        group.put("name", name);
        param.put("group", group);
        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, CreateGroupResponse.class);
        return response;
    }

    /**
     * 获取所有分组信息
     *
     * @return 所有分组信息列表对象
     */
    public GetGroupsResponse getGroups() {
        GetGroupsResponse response = null;
        LOG.debug("获取所有分组信息.....");
        String url = BASE_API_URL + "cgi-bin/groups/get?access_token=#";
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, GetGroupsResponse.class);
        return response;
    }

    /**
     * 通过关注者ID获取所在分组信息
     *
     * @param openid 关注者ID
     * @return 所在分组信息
     */
    public String getGroupIdByOpenid(String openid) {
        BeanUtil.requireNonNull(openid, "openid is null");
        LOG.debug("通过关注者ID获取所在分组信息.....");
        String result = null;
        String url = BASE_API_URL + "cgi-bin/groups/getid?access_token=#";
        Map<String, String> params = new HashMap<String, String>();
        params.put("openid", openid);
        BaseResponse r = executePost(url, JSONUtil.toJson(params));
        if (isSuccess(r.getErrcode())) {
            result = JSONUtil.toMap(r.getErrmsg()).get("groupid").toString();
        }
        return result;
    }

    /**
     * 修改分组信息
     *
     * @param groupid 分组ID
     * @param name    新名称
     * @return 调用结果
     */
    public ResultType updateGroup(Integer groupid, String name) {
        BeanUtil.requireNonNull(groupid, "groupid is null");
        BeanUtil.requireNonNull(name, "name is null");
        LOG.debug("修改分组信息.....");
        String url = BASE_API_URL + "cgi-bin/groups/update?access_token=#";
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> group = new HashMap<String, Object>();
        group.put("id", groupid);
        group.put("name", name);
        param.put("group", group);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 移动关注者所在分组
     *
     * @param openid    关注者ID
     * @param toGroupid 新分组ID
     * @return 调用结果
     */
    public ResultType moveGroupUser(String openid, String toGroupid) {
        BeanUtil.requireNonNull(openid, "openid is null");
        BeanUtil.requireNonNull(toGroupid, "toGroupid is null");
        LOG.debug("移动关注者所在分组.....");
        String url = BASE_API_URL + "cgi-bin/groups/members/update?access_token=#";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("openid", openid);
        param.put("to_groupid", toGroupid);

        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 获取关注者信息
     *
     * @param openid 关注者ID
     * @return 关注者信息对象
     */
    public GetUserInfoResponse getUserInfo(String openid) {
        BeanUtil.requireNonNull(openid, "openid is null");
        GetUserInfoResponse response = null;
        LOG.debug("获取关注者信息.....");
        String url = BASE_API_URL + "cgi-bin/user/info?access_token=#&lang=zh_CN&openid=" + openid;
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, GetUserInfoResponse.class);
        return response;
    }
}