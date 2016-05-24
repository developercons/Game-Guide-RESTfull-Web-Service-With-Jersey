package com.margin.game_guide_server.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Martha on 5/12/2016.
 */
public class GameRequestModel {
    @Expose
    private String category;
    @Expose
    private Long id;

    public String getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }
}
