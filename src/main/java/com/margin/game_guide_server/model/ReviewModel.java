package com.margin.game_guide_server.model;

import com.margin.game_guide_server.data.DataBase;

/**
 * Created by Martha on 5/1/2016.
 */
public class ReviewModel {
    private String userToken;
    private UserModel userModel;
    private String review;

    public ReviewModel(String userToken, String review) {
        this.userToken = userToken;
        this.userModel = DataBase.instance().getUserMap().get(DataBase.instance().getMailMap().get(userToken));
        this.review = review;
    }
}
