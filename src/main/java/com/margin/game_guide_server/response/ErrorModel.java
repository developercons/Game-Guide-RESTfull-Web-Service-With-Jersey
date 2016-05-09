package com.margin.game_guide_server.response;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Martha on 4/30/2016.
 */
@XmlRootElement
public class ErrorModel {
    @Expose
    private int code;
    @Expose
    private String message;

    public ErrorModel(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public ErrorModel() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
