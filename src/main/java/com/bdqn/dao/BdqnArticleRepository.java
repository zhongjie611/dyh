package com.bdqn.dao;

import com.bdqn.module.BdqnArticle;

/**
* Created by zezhong.shang on 16-1-15.
*/
public class BdqnArticleRepository extends AbstractRepository<BdqnArticle> {

    @Override
    protected Class<BdqnArticle> getEntityClass() {
        return BdqnArticle.class;
    }

    @Override
    protected String getId(BdqnArticle bdqnArticle) {
        return bdqnArticle.getId();
    }

}
