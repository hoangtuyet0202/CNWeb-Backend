package com.cnweb.mxh.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.lang.reflect.Type;

// JsonResult for convert object to json and convert json to object
public class JsonResult {
    private String message;
    private Object data;

    public JsonResult() {
    }

    public JsonResult(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String jsonSuccess(Object data){
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
        return gson.toJson(new JsonResult("success", data));
    }

    public String jsonFail(Object data){
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
        return gson.toJson(new JsonResult("fail", data));
    }

    // convert json to object
    public <T> T convertObject(T t,Reader reader){
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
        return gson.fromJson(reader, (Type) t.getClass());
    }
}

