package com.bdqn.controller;
import com.bdqn.module.BdqnArticle;
import com.bdqn.service.IBdqnArticleService;
import com.zxs.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Meta;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zezhong.shang on 16-1-25.
 */
@Controller
@RequestMapping("/wx/bdqnArticle")
public class WxArticleController {


    @Autowired
    private IBdqnArticleService bdqnArticleService;

    @RequestMapping("/queryBdqnArticleDetail")
    public String queryBdqnArticleDetail(String bdqnArticleId,ModelMap modelMap) throws Exception {
        BdqnArticle bdqnArticle=bdqnArticleService.queryBdqnArticleById(bdqnArticleId);
        modelMap.addAttribute("bdqnArticle",bdqnArticle);
        return "/pre/queryBdqnArticleDetail";
    }

    @RequestMapping("/toQueryBdqnArticleList")
    public String toQueryBdqnArticleList(String type,ModelMap mode){
        mode.addAttribute("type", type);
        return "/pre/queryBdqnArticleList";
    }

    @RequestMapping("/queryBdqnArticleList")
     @ResponseBody
     public Page<BdqnArticle> queryBdqnArticleList(Integer pageNo, Integer pageSize,String type) throws Exception {
        if(pageNo==null || pageNo==0) pageNo=1;
        if(pageSize==null || pageSize==0) pageSize=10;
        Query query=new Query();
        query.addCriteria(new Criteria("type").is(type));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "createdDate")));
        return bdqnArticleService.queryBdqnArticlePage(pageNo,pageSize, query);
    }

    @RequestMapping("/index")
    public String index() throws Exception {
        return "/pre/index";
    }
}
