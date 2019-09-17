package com.bdqn.service.impl;

import com.bdqn.dao.XXTExpressInfoRepository;
import com.bdqn.module.ExpressInfo;
import com.bdqn.service.IExpressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressInfoServiceImpl implements IExpressInfoService {


    @Autowired
    private XXTExpressInfoRepository epressInfoRepository;


    public void removeAll() {
        epressInfoRepository.removeAll();
    }

    public void removeBy(ExpressInfo expressInfo) {
        epressInfoRepository.removeOne(expressInfo.getId());
    }

    public void saveExpressInfo(List<ExpressInfo> list) {
       for(ExpressInfo e : list){
           epressInfoRepository.insert(e);
       }

    }

    public List<ExpressInfo> find(ExpressInfo expressInfo) {
        Query query=new Query();
        query.addCriteria(new Criteria("userName").is(expressInfo.getUserName()));
        return epressInfoRepository.find(query);
    }

    public List<ExpressInfo> find(String name) {
        Query query=new Query();
        query.addCriteria(new Criteria("userName").is(name));
        return epressInfoRepository.find(query);
    }
}
