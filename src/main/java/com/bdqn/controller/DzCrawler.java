package com.bdqn.controller;

import com.bdqn.module.BdqnArticle;
import com.bdqn.service.IBdqnArticleService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;

/**
 * Created by zezhong.shang on 16-4-7.
 */
@Controller
@RequestMapping("/waduanzi")
public class DzCrawler {
    @Autowired
    IBdqnArticleService bdqnArticleService;

    //�����url
    @RequestMapping
    public void crawler() throws IOException {
        for (int i = 0; i < 20; i++) {
            try {
                String url = "http://www.waduanzi.com/page/" + i;
                Document document = Jsoup.connect(url).get();
                //�õ�����div��
                Elements elements = document.select("div[class=panel panel20 post-item post-box]>div[class=item-detail]");
                for (Element element : elements) {
                    BdqnArticle article = new BdqnArticle();
                    String title = element.select("h2[class=item-title]").text();
                    String content = element.select("div[class=item-content]").html();
                    if(StringUtils.isEmpty(title) || StringUtils.isEmpty(content)){
                        continue;
                    }
                    article.setTitle(title);
                    article.setType("pengfu");
                    article.setContent(content);
                    article.setCreatedDate(new Date());
                    article.setContentHtml(content);
                    System.out.println(article.getTitle() + ":" + article.getContent());
                    bdqnArticleService.saveOrUpdateBdqnArticle(article);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
