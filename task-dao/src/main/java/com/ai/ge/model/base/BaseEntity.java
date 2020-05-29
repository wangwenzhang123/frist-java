package com.ai.ge.model.base;

import org.kohsuke.rngom.parse.host.Base;

public class BaseEntity {
    private int code;
    private boolean success;
    private String msg;
    private Object data;

    public BaseEntity(int code, boolean success, String msg, Object data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static BaseEntity success(Object data){
        return new BaseEntity(200,true,"操作成功",data);
    }
    public static BaseEntity failure(){
        return new BaseEntity(-1,false,"操作失败",null);
    }
}
