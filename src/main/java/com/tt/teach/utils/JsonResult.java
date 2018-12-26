package com.tt.teach.utils;
/**
 *@作者:lizejuan
 *@时间:2018/12/20 16:13
 *@描述:返回json数据的工具包
 */
public class JsonResult {
    //1.响应状态码
    private Integer status;
    //2.响应消息
    private String myMsg;
    //3.响应数据
    private Object myDate;
    //封装

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMyMsg() {
        return myMsg;
    }
    public void setMyMsg(String myMsg) {
        this.myMsg = myMsg;
    }
    public Object getMyDate() {
        return myDate;
    }
    public void setMyDate(Object myDate) {
        this.myDate = myDate;
    }
    //无参
    public JsonResult() {
    }
    //有参
    public JsonResult(Integer status, String myMsg, Object myDate) {
        this.status = status;
        this.myMsg = myMsg;
        this.myDate = myDate;
    }
    //成功时候调用OK
    public static JsonResult ok( String myMsg, Object myDate) {
        return new JsonResult(200,myMsg,myDate);
    }
    //失败时候调用no
    public static JsonResult no( String myMsg, Object myDate) {
        return new JsonResult(502,myMsg,myDate);
    }
}
