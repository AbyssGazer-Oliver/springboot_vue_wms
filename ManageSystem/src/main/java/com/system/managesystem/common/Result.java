package com.system.managesystem.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg; // succeed or not
    private long total;
    private Object data;

    public static Result fail(){
        return result(400,"失败",0L,null);
    }
    public static Result succeed(){
        return result(200,"成功",0L,null);
    }
    public static Result succeed(Object data){
        return result(200,"成功",0L,data);
    }
    public static Result succeed(Object data,long total){
        return result(200,"成功",total,data);
    }
    private static Result result(int code, String msg,long total, Object data){
        Result result=new Result();
        result.setData(data);
        result.setMsg(msg);
        result.setCode(code);
        result.setTotal(total);
        return result;
    }
}
