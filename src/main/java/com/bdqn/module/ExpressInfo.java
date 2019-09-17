package com.bdqn.module;

import java.io.Serializable;
import java.util.Date;

public class ExpressInfo  implements Serializable {

    private String id;
    private  String orderNumb;
    private  String userName;
    private Date createDate;
    private boolean recStates;
    private boolean sendStates;
    private String product;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumb() {
        return orderNumb;
    }

    public void setOrderNumb(String orderNumb) {
        this.orderNumb = orderNumb;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isRecStates() {
        return recStates;
    }

    public void setRecStates(boolean recStates) {
        this.recStates = recStates;
    }

    public boolean isSendStates() {
        return sendStates;
    }

    public void setSendStates(boolean sendStates) {
        this.sendStates = sendStates;
    }
}
