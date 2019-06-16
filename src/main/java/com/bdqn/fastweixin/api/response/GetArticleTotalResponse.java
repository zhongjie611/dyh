package com.bdqn.fastweixin.api.response;

import com.bdqn.fastweixin.api.entity.ArticleTotal;

import java.util.List;

/**
 * @author peiyu
 */
public class GetArticleTotalResponse extends BaseResponse {

    private List<ArticleTotal> list;

    public List<ArticleTotal> getList() {
        return list;
    }

    public void setList(List<ArticleTotal> list) {
        this.list = list;
    }
}
