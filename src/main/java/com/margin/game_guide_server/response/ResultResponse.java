package com.margin.game_guide_server.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Martha on 4/30/2016.
 */
@XmlRootElement
public class ResultResponse<T> {
    private T result;

    public ResultResponse(T result) {
        this.result = result;
    }
    public ResultResponse() {
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
