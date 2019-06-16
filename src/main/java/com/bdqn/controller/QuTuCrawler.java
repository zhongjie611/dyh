package com.bdqn.controller;
import com.bdqn.module.BdqnArticle;
import com.bdqn.service.IBdqnArticleService;
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
@RequestMapping("/qutu")
public class QuTuCrawler {
    @Autowired
    IBdqnArticleService bdqnArticleService;
    @RequestMapping
    public void crawler() throws IOException {
        for (int i=0;i<1;i++){
            try{
                String url="http://wap.xxhh.com/";
                Document document= Jsoup.connect(url).get();
                //�õ�����div��
                Elements elements=document.select("article[class=box]");
                for(Element element:elements){
                    BdqnArticle article=new BdqnArticle();
                    String title=element.select("section[class=box-head]").text();
                    String content=element.select("a>pre").html();
                    article.setTitle(title);
                    article.setType("qutu");
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
    /*public void crawler() throws IOException {
        for (int i=2;i<200;i++){
            try{
                String url="http://www.zbjuran.com/quweitupian/list_2_"+i+".html";
                Document document= Jsoup.connect(url).get();
                //�õ�����div��
                Elements elements=document.select("div[class=main]>div[class=item]");
                for(Element element:elements){
                    BdqnArticle article=new BdqnArticle();
                    String title=element.select("h3>a").text();
                    String content=element.select("div[class=text]").html();
                    article.setTitle(title);
                    article.setType("qutu");
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
    }*/
}
