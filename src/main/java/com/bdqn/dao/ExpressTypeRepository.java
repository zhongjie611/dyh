package com.bdqn.dao;

import com.bdqn.module.ExpressType;

public class ExpressTypeRepository  extends AbstractRepository<ExpressType>  {


    protected Class<ExpressType> getEntityClass() {
        return ExpressType.class;
    }

    protected String getId(ExpressType expressType) {
        return expressType.getId();
    }
}
