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
@RequestMapping("/wangyi")
public class WangYiCrawler {

    @Autowired
    IBdqnArticleService bdqnArticleService;

    @RequestMapping
    public void crawler() throws IOException {
        for (int i=2;i<10;i++){
            try{
                String url="http://news.163.com/special/0001124J/guoneinews_0"+i+".html#headList"+i;
                Document document= Jsoup.connect(url).get();
                //�õ�����div��
                Elements elements=document.select("div[class=list-item clearfix]>div[class=item-top]>h2>a");
                for(Element element:elements){
                    BdqnArticle article=new BdqnArticle();
                    String title=element.text();
                    //�õ����ݳ�����
                    String contentUrl=element.absUrl("href");
                    //�õ����ݵ�Dom
                    Document contentDocument= Jsoup.connect(contentUrl).get();
                    //��������
                    Elements contentElement=contentDocument.select("#endText");
                    String content=contentElement.html();
                    article.setTitle(title);
                    article.setType("wangyi");
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
    public static void main(String args[]) throws IOException {

    }
}
