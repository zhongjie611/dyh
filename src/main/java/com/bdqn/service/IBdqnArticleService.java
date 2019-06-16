package com.bdqn.service;
import com.bdqn.module.BdqnArticle;
import com.zxs.common.Page;
import org.springframework.data.mongodb.core.query.Query;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface IBdqnArticleService {

    public int saveOrUpdateBdqnArticle(BdqnArticle obj)throws Exception;

    public BdqnArticle queryBdqnArticleById(String id)throws Exception;

    public Page<BdqnArticle> queryBdqnArticlePage(int pageNo, int pageSize, Query query)throws Exception;

    public BdqnArticle queryRandomBdqnArticle(String type)throws Exception;
}
