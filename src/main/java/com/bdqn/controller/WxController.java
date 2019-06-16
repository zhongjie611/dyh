package com.bdqn.controller;
import com.alibaba.fastjson.JSON;
import com.bdqn.module.BdqnArticle;
import com.bdqn.service.IBdqnArticleService;
import com.bdqn.fastweixin.api.MenuAPI;
import com.bdqn.fastweixin.api.config.ApiConfig;
import com.bdqn.fastweixin.api.entity.Menu;
import com.bdqn.fastweixin.api.entity.MenuButton;
import com.bdqn.fastweixin.api.enums.MenuType;
import com.bdqn.fastweixin.api.enums.ResultType;
import com.bdqn.fastweixin.message.Article;
import com.bdqn.fastweixin.message.BaseMsg;
import com.bdqn.fastweixin.message.NewsMsg;
import com.bdqn.fastweixin.message.TextMsg;
import com.bdqn.fastweixin.message.req.BaseEvent;
import com.bdqn.fastweixin.message.req.TextReqMsg;
import com.bdqn.fastweixin.servlet.WeixinControllerSupport;
import com.zxs.utils.lang.EmptyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zezhong.shang on 16-1-8.
 */

@Controller
@RequestMapping("/wx/admin/")
public class WxController extends WeixinControllerSupport {

    //static private String SUBDOMAINURL =  "http://120.79.163.96/dyh";
    //static private String SUBDOMAINURL = "http://localhost:8080/collect";

    //@Value("${IMAGE_SERVER_URL}")
   // private String IMAGE_SERVER_URL;
    @Value("${SUBDOMAINURL}")
    private String SUBDOMAINURL;
    @Autowired
    private ApiConfig apiConfig;

    private static final Logger log = LoggerFactory.getLogger(WxController.class);

    @Override
    protected String getToken() {
        return apiConfig.getToken();
    }

    @Override
    protected String getAppId() {
        return apiConfig.getAppid();
    }

    @Override
    protected String getAESKey() {
        return "";
    }

    @Autowired
    private IBdqnArticleService bdqnArticleService;

    @ResponseBody
    @RequestMapping(value="/createMenu", produces="text/html;charset=UTF-8")
    public String createMenu() {
        try {
            MenuAPI menuApi = new MenuAPI(apiConfig);
            Menu menu = new Menu();
            MenuButton topMenu1 = new MenuButton();
            MenuButton topMenu2 = new MenuButton();
            MenuButton topMenu3 = new MenuButton();

            topMenu1.setName("IT看见");
            topMenu2.setName("乐一乐");
            topMenu3.setName("关于我们");

            List<MenuButton> sub1_list = new ArrayList<MenuButton>();
            List<MenuButton> sub2_list = new ArrayList<MenuButton>();
            List<MenuButton> sub3_list = new ArrayList<MenuButton>();

            MenuButton menuButton_11=new MenuButton();
            MenuButton menuButton_12=new MenuButton();
            MenuButton menuButton_13=new MenuButton();

            MenuButton menuButton_21=new MenuButton();
            MenuButton menuButton_22=new MenuButton();

            MenuButton menuButton_31=new MenuButton();
            MenuButton menuButton_32=new MenuButton();
//            MenuButton menuButton_33=new MenuButton();
//            MenuButton menuButton_34=new MenuButton();

            menuButton_11.setName("修炼秘籍");
            menuButton_11.setType(MenuType.VIEW);
            menuButton_11.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/toQueryBdqnArticleList?type=csdn");
            menuButton_12.setName("挨踢新闻");
            menuButton_12.setType(MenuType.VIEW);
            menuButton_12.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/toQueryBdqnArticleList?type=wangyi");

            menuButton_13.setName("首页");
            menuButton_13.setType(MenuType.VIEW);
            menuButton_13.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/index");

            menuButton_21.setName("笑话");
            menuButton_21.setType(MenuType.VIEW);
            menuButton_21.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/toQueryBdqnArticleList?type=pengfu");

            menuButton_22.setName("趣图");
            menuButton_22.setType(MenuType.VIEW);
            menuButton_22.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/toQueryBdqnArticleList?type=qutu");

            menuButton_31.setName("企业文化");
            menuButton_31.setType(MenuType.VIEW);
            menuButton_31.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId=s1");

            menuButton_32.setName("猿圈功能");
            menuButton_32.setType(MenuType.VIEW);
            menuButton_32.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId=s2");


//            menuButton_33.setName("每日工作");
//            menuButton_33.setType(MenuType.VIEW);
//            menuButton_33.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/toQueryBdqnArticleList?type=job");
//
//            menuButton_34.setName("编写日志");
//            menuButton_34.setType(MenuType.VIEW);
//            menuButton_34.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/workJob");

            sub1_list.add(menuButton_13);
            sub1_list.add(menuButton_11);
            sub1_list.add(menuButton_12);


            sub2_list.add(menuButton_21);
            sub2_list.add(menuButton_22);

            sub3_list.add(menuButton_31);
            sub3_list.add(menuButton_32);

            List<MenuButton> mbs = new ArrayList<MenuButton>();
            topMenu1.setSubButton(sub1_list);
            topMenu2.setSubButton(sub2_list);
            topMenu3.setSubButton(sub3_list);

            mbs.add(topMenu1);
            mbs.add(topMenu2);
            mbs.add(topMenu3);
            menu.setButton(mbs);
            System.out.println(JSON.toJSON(menu));
            ResultType rt = menuApi.createMenu(menu);
            String a="哈哈";
            System.out.println(a);
            return rt.getDescription();

        } catch (Exception e) {
            e.printStackTrace();
            return "菜单创建异常";
        }
    }

    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        log.debug("用户发送到服务器的内容:{}", content);
        BdqnArticle bdqnArticle = null;
        NewsMsg newsMsg = new NewsMsg();
        Article article = null;
        try {
            if (content.equals("1") || content.equals("新闻")) {
                bdqnArticle = bdqnArticleService.queryRandomBdqnArticle("wangyi");
                article = new Article();
                article.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId=" + bdqnArticle.getId());
                article.setDescription("");
                article.setPicUrl(SUBDOMAINURL + "/resources/pre/images/news.jpg");
                article.setTitle(bdqnArticle.getTitle());
            } else if (content.equals("2") || content.equals("段子")) {
                bdqnArticle = bdqnArticleService.queryRandomBdqnArticle("pengfu");
                article = new Article();
                article.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId=" + bdqnArticle.getId());
                article.setDescription("");
                article.setPicUrl(SUBDOMAINURL + "/resources/pre/images/joke.jpg");
                article.setTitle(bdqnArticle.getTitle());
            } else if (content.equals("4") || content.equals("趣图")) {
                bdqnArticle = bdqnArticleService.queryRandomBdqnArticle("pengfu");
                article = new Article();
                article.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId=" + bdqnArticle.getId());
                article.setDescription("");
                article.setPicUrl(SUBDOMAINURL + "/resources/pre/images/joke1.jpg");
                article.setTitle(bdqnArticle.getTitle());
            } else if (content.equals("3") || content.equals("技术")) {
                bdqnArticle = bdqnArticleService.queryRandomBdqnArticle("csdn");
                article = new Article();
                article.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId=" + bdqnArticle.getId());
                article.setDescription("");
                article.setPicUrl(SUBDOMAINURL + "/resources/pre/images/js.jpg");
                article.setTitle(bdqnArticle.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (EmptyUtils.isEmpty(article)) {
                return new TextMsg("亲们,小猿还是个屌丝,听不懂你们高富帅说的高级话.");
            }else{
                newsMsg.add(article);
            }
            return newsMsg;
        }
    }

    @Override
    protected BaseMsg handleSubscribe(BaseEvent event){
        NewsMsg newsMsg = new NewsMsg();
        Article article = new Article();
        article.setUrl(SUBDOMAINURL + "/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId=s2");
        article.setDescription("点击进入查看猿圈更多功能");
        article.setPicUrl(SUBDOMAINURL + "/resources/pre/images/hy.jpg");
        article.setTitle("欢迎欢迎 我们又多了个屌丝!");
        newsMsg.add(article);
        return newsMsg;
    }
}
