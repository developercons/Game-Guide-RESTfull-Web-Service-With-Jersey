package com.margin.game_guide_server.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Martha on 5/1/2016.
 */
public class ReviewModel {
    private UserModel userModel;
    @Expose
    private String author;
    @Expose
    private byte[] profPic;
    @Expose
    private String review;

    public ReviewModel(UserModel userModel, String review) {
        this.userModel = userModel;
        this.review = review;
        update();
    }

    public void update() {
        this.author = userModel.getFullName();
        this.profPic = userModel.getAvatarBytes();
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public String getAuthor() {
        return author;
    }

    public byte[] getProfPic() {
        return profPic;
    }

    public String getReview() {
        return review;
    }
}
