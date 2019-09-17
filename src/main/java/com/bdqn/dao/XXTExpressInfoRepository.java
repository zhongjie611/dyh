package com.bdqn.dao;

import com.bdqn.module.ExpressInfo;


public class XXTExpressInfoRepository extends AbstractRepository<ExpressInfo> {
    protected Class<ExpressInfo> getEntityClass() {
        return ExpressInfo.class;
    }

    protected String getId(ExpressInfo expressInfo) {
        return expressInfo.getId();
    }
}

