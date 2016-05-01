package com.margin.game_guide_server.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Martha on 4/30/2016.
 */
@XmlRootElement
public class ErrorResponse {
    private ErrorModel error;

    public ErrorResponse(int code, String message) {
        error = new ErrorModel(code, message);
    }

    public ErrorResponse() {
    }

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }
}
