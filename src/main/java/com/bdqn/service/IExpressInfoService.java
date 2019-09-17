package com.bdqn.service;

import com.bdqn.module.ExpressInfo;

import java.util.List;

public interface IExpressInfoService {
    public void removeAll();
    public void removeBy(ExpressInfo expressInfo);
    public void saveExpressInfo(List<ExpressInfo> list );
    public List<ExpressInfo> find(ExpressInfo expressInfo);

    List<ExpressInfo> find(String name);
}
