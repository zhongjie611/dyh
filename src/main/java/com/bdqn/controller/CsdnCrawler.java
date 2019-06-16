package com.bdqn.controller;
import com.bdqn.dao.BdqnArticleRepository;
import com.bdqn.module.BdqnArticle;
import com.bdqn.service.IBdqnArticleService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;

/**
 * Created by zezhong.shang on 16-4-7.
 */
@Controller
@RequestMapping("/csdn")
public class CsdnCrawler {

    @Autowired
    IBdqnArticleService bdqnArticleService;

    @RequestMapping
    public void crawler() throws IOException {
        try{
            //http://blog.csdn.net/nav/news
            String url="http://blog.csdn.net/";
            Connection connection=Jsoup.connect(url);
            connection.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            connection.header("Accept-Encoding","gzip, deflate");
            connection.header("Accept-Language","zh-CN,zh;q=0.9");
            connection.header("Cache-Control","max-age=0");
            connection.header("Connection", "keep-alive");
            connection.header("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
            connection.header("Cookie","TY_SESSION_ID=7e138ae4-789b-436a-a868-6f85d636c8e9; uuid_tt_dd=1062200842298346678_20171127; __yadk_uid=G0XbV48bIfWfGDr1isS9f7te8tdsZaFj; Hm_lvt_a7b49ce94663a59587d86469dcefa458=1516870140; __utma=17226283.3472996.1516871254.1516871254.1516871254.1; __utmz=17226283.1516871254.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ADHOC_MEMBERSHIP_CLIENT_ID1.0=e818e7ad-a767-6a79-6ec7-04b2285906f2; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; __message_district_code=000000; __message_in_school=0; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; kd_user_id=43460de4-3d20-4211-8228-225d0ae5fa64; uuid=52bce133-3e5a-4f1b-b44a-73e451d9faf2; dc_session_id=10_1517359493944.181148; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1517377900,1517378260,1517378435,1517383219; dc_tos=p3evss; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1517387644");
            connection.header("Host","blog.csdn.net");
            connection.header("Upgrade-Insecure-Requests","1");
            connection.header("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            Document document= connection.get();
            //�õ�����div��

            Elements elements=document.select("h2[class=csdn-tracking-statistics]>a");
            for(Element element:elements){
                BdqnArticle article=new BdqnArticle();
                String title=element.text();
                //�õ����ݳ�����
                String contentUrl=element.absUrl("href");
                //�õ����ݵ�Dom
                Connection contentConnection=Jsoup.connect(contentUrl);
                contentConnection.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                contentConnection.header("Accept-Encoding","gzip, deflate, sdch");
                contentConnection.header("Accept-Language","zh-CN,zh;q=0.8");
                contentConnection.header("Cache-Control","max-age=0");
                contentConnection.header("Connection", "keep-alive");
                contentConnection.header("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
                contentConnection.header("Cookie","uuid_tt_dd=-7287016780307873738_20151221; __gads=ID=5263db03fc7e988d:T=1450688455:S=ALNI_MYzpUy5lBtl8DDYcG5WKXUwNyGhkw; __qca=P0-2004748507-1450688412037; bdshare_firstime=1450745642341; _ga=GA1.2.229904132.1451899124; _JQCMT_browser=a71b15599474cdc7f483018f69812fc4; _JQCMT_ifcookie=1; __utma=17226283.229904132.1451899124.1452216244.1453688451.3; __utmz=17226283.1453688451.3.3.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; lzstat_uv=2437943853573843981|3343685@3609445@3504240@3017872; __message_district_code=110000; UN=shangyishang; UE=\"1044732267@qq.com\"; BT=1459836613232; uuid=743c1f5c-2c92-42e2-842c-6d5e25a6f78c; _message_m=l0s4zgj3ao23m5rdx03wzhwl; avh=51024089%2c51027983%2c8631897; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; __message_in_school=0; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1459841472,1459993742; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1459994990; dc_tos=o58rcf; dc_session_id=1459994991250");
                contentConnection.header("Host","blog.csdn.net");
                contentConnection.header("If-Modified-Since","Thu, 07 Apr 2016 02:10:46 GMT");
                contentConnection.header("Upgrade-Insecure-Requests","1");
                Document contentDocument= contentConnection.get();
                //��������
                Elements contentElement=contentDocument.select("div[class=container clearfix]");
                String content=contentElement.html();
                article.setTitle(title);
                article.setType("csdn");
                article.setContent(content);
                article.setContentHtml(content);
                article.setCreatedDate(new Date());
                System.out.println(article.getTitle() + ":" + article.getContent());
                bdqnArticleService.saveOrUpdateBdqnArticle(article);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
