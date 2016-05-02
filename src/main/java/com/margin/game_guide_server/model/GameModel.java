package com.margin.game_guide_server.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

/**
 * Created by Martha on 5/1/2016.
 */
public class GameModel {
    @Expose
    private long id;
    @Expose
    private String name;
    @Expose
    private String category;
    @Expose
    private int reviewQuantity;
    @Expose
    private int expertMark;
    @Expose
    private String ageRange;
    @Expose
    private String expertDefinition;
    @Expose
    private String expertReview;
    @Expose
    private byte[] avatar;
    @Expose
    private ArrayList<ReviewModel> reviews = new ArrayList<>();

    public GameModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewQuantity() {
        return reviewQuantity;
    }

    public void setReviewQuantity(int reviewQuantity) {
        this.reviewQuantity = reviewQuantity;
    }

    public int getExpertMark() {
        return expertMark;
    }

    public void setExpertMark(int expertMark) {
        this.expertMark = expertMark;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getExpertDefinition() {
        return expertDefinition;
    }

    public void setExpertDefinition(String expertDefinition) {
        this.expertDefinition = expertDefinition;
    }

    public String getExpertReview() {
        return expertReview;
    }

    public void setExpertReview(String expertReview) {
        this.expertReview = expertReview;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public ArrayList<ReviewModel> getReviews() {
        return reviews;
    }

    public ArrayList addReview(ReviewModel newReview) {
        this.reviews.add(newReview);
        return reviews;
    }
}
