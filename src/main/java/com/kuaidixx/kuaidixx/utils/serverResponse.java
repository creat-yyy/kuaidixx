package com.kuaidixx.kuaidixx.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

//封装统一的前端返回的实体类
//status: 0接口调用成功 非0为调用失败
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class serverResponse<T> {
    private int status;
    private T data;
    private String msg;

    public serverResponse(){

    }
    private serverResponse(int status){
        this.status=status;
    }
    private serverResponse(int status,T data){
        this.status=status;
        this.data=data;
    }
    private serverResponse(int status,T data,String msg){
        this.status=status;
        this.data=data;
        this.msg=msg;
    }
    //判断接口调用是否成功
    public boolean isSuccess(){
        return this.status==0;
    }
    //封装serverResponse成功
    public static serverResponse createServerResponseBySucccess(){
        return new serverResponse(0);
    }
    public static <T> serverResponse createServerResponseBySucccess(T data){
        return new serverResponse(0,data);
    }
    public static <T> serverResponse createServerResponseBySucccess(T data,String msg){
        return new serverResponse(0,data,msg);
    }
    //封装serverResponse失败
    public static <T> serverResponse createServerResponseByFail(int status,String msg){
        return new serverResponse(status,null,msg);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
