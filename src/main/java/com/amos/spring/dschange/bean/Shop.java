package com.amos.spring.dschange.bean;

import java.util.Date;

/**
 * User: Baron.Zhang
 * Date: 14-1-6
 * Time: 下午5:19
 */
public class Shop {

    /** 主键id */
    private Integer id;

    /** 外部平台店铺id */
    private String shopId;

    /** 店铺所属类目id */
    private String catId;

    /** 卖家昵称 */
    private String nick;

    /** 店铺标题 */
    private String title;

    /** 店铺描述 */
    private String description;

    /** 店铺公告 */
    private String bulletin;

    /** 店标地址 */
    private String picPath;

    /** 商品描述评分 */
    private String itemScore;

    /** 服务态度评分 */
    private String serviceScore;

    /** 发货速度评分 */
    private String deliveryScore;

    /** 默认快递 */
    private String deExpress;

    /** 是否启用发货短信 */
    private Boolean enableMsg;

    /** 发货短信模板 */
    private String msgTemp;

    /** 短信签名 */
    private String msgSign;

    /** 店铺来自哪个平台（如天猫，京东） */
    private String outPlatformType;

    /** 开店时间 */
    private Date createTime;

    /** 最后修改时间 */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getItemScore() {
        return itemScore;
    }

    public void setItemScore(String itemScore) {
        this.itemScore = itemScore;
    }

    public String getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(String serviceScore) {
        this.serviceScore = serviceScore;
    }

    public String getDeliveryScore() {
        return deliveryScore;
    }

    public void setDeliveryScore(String deliveryScore) {
        this.deliveryScore = deliveryScore;
    }

    public String getDeExpress() {
        return deExpress;
    }

    public void setDeExpress(String deExpress) {
        this.deExpress = deExpress;
    }

    public Boolean getEnableMsg() {
        return enableMsg;
    }

    public void setEnableMsg(Boolean enableMsg) {
        this.enableMsg = enableMsg;
    }

    public String getMsgTemp() {
        return msgTemp;
    }

    public void setMsgTemp(String msgTemp) {
        this.msgTemp = msgTemp;
    }

    public String getMsgSign() {
        return msgSign;
    }

    public void setMsgSign(String msgSign) {
        this.msgSign = msgSign;
    }

    public String getOutPlatformType() {
        return outPlatformType;
    }

    public void setOutPlatformType(String outPlatformType) {
        this.outPlatformType = outPlatformType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString(){
        return "Shop={" +
                "id = " + id + "," +
                "shopId = " + shopId + "," +
                "catId = " + catId + "," +
                "nick = " + nick + "," +
                "title = " + title + "," +
                "description = " + description + "," +
                "bulletin = " + bulletin + "," +
                "picPath = " + picPath + "," +
                "itemScore = " + itemScore + "," +
                "serviceScore = " + serviceScore + "," +
                "deliveryScore = " + deliveryScore + "," +
                "deExpress = " + deExpress + "," +
                "enableMsg = " + enableMsg + "," +
                "msgTemp = " + msgTemp + "," +
                "msgSign = " + msgSign + "," +
                "outPlatformType = " + outPlatformType + "," +
                "createTime = " + createTime + "," +
                "updateTime = " + updateTime +
                "}";
    }
}
