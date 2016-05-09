package com.margin.game_guide_server.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Martha on 5/8/2016.
 */
public class ResponseBundle <T> {
    @SerializedName("result")
    @Expose
    private T result;
    @SerializedName("error")
    @Expose
    private ErrorModel error;

    public ResponseBundle(int errorCode, String message) {
        this.error = new ErrorModel(errorCode, message);
    }

    public ResponseBundle(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public ErrorModel getError() {
        return error;
    }
}
