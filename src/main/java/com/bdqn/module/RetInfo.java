package com.bdqn.module;

import java.util.Date;

/**
 * Created by Administrator on 2019-07-18.
 */
public class RetInfo {
    private Integer id;
    private String title;
    private Date add_time = getRandomTIme();
    private Date ctime = getRandomTIme();
    private String content = "我来评论滚" + (int)(1+Math.random()*(10-1+1));;
    private String goods_no;
    private Integer stock_quantity;
    private Integer market_price;
    private Integer sell_price;
    private String url;
    private String img;
    private String img_url;
    private String thumb_path;
    private Integer cou;
    private String zhaiyao;
    private Integer click;
    private String src;
    private String user_name = "阿猫阿狗"+(int)(1+Math.random()*(10-1+1));
    private Date getRandomTIme(){
        Date rd = new Date();
       //*(n-m)+m，生成大于等于m小于n的随机
        int m = (int)(Math.random()*(60-0)+0);
        rd.setMinutes(m);
        int s = (int)(Math.random()*(60-0)+0);
        rd.setSeconds(s);
        return rd;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Integer getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Integer market_price) {
        this.market_price = market_price;
    }

    public Integer getSell_price() {
        return sell_price;
    }

    public void setSell_price(Integer sell_price) {
        this.sell_price = sell_price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getThumb_path() {
        return thumb_path;
    }

    public void setThumb_path(String thumb_path) {
        this.thumb_path = thumb_path;
    }

    public Integer getCou() {
        return cou;
    }

    public void setCou(Integer cou) {
        this.cou = cou;
    }

    public String getZhaiyao() {
        return zhaiyao;
    }

    public void setZhaiyao(String zhaiyao) {
        this.zhaiyao = zhaiyao;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
