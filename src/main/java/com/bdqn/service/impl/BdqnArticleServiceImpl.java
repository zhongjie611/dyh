package com.bdqn.service.impl;
import com.bdqn.dao.BdqnArticleRepository;
import com.bdqn.module.BdqnArticle;
import com.bdqn.service.IBdqnArticleService;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Random;

@Service
public class BdqnArticleServiceImpl implements IBdqnArticleService {

    @Autowired
    private BdqnArticleRepository bdqnArticleRepository;

    public int saveOrUpdateBdqnArticle(BdqnArticle bdqnArticle) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(bdqnArticle.getId())){
            Update update=new Update();
            bdqnArticle.setUpdatedDate(new Date());
            bdqnArticleRepository.modify(bdqnArticle,update);
        }else{
            bdqnArticle.setCreatedDate(new Date());
            bdqnArticleRepository.insert(bdqnArticle);
        }
        return flag;
    }

    public BdqnArticle queryBdqnArticleById(String id) throws Exception{
        return bdqnArticleRepository.findOne(id);
    }

    public Page<BdqnArticle> queryBdqnArticlePage(int pageNo, int pageSize, Query query)throws Exception{
        return bdqnArticleRepository.queryPage(pageNo,pageSize,query);
    }

    public BdqnArticle queryRandomBdqnArticle(String type)throws Exception {
        Query query=new Query();
        query.addCriteria(new Criteria("type").is(type));
        Random rand = new Random();
        int i = rand.nextInt(100); //生成0-100以内的随机数
        Page<BdqnArticle> bdqnArticlePage=bdqnArticleRepository.queryPage(i, 1,query);
        if(EmptyUtils.isEmpty(bdqnArticlePage)){
            i = rand.nextInt(10);
            bdqnArticlePage=bdqnArticleRepository.queryPage(i, 1,query);
        }
        return bdqnArticlePage.getRows().get(0);
    }
}
