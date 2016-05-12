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
    private int expertMark;
    @Expose
    private String ageRange;
    @Expose
    private String expertDefinition;
    @Expose
    private String expertReview;

    private ArrayList<ReviewModel> reviews = new ArrayList<>();


    private byte[] avatar;

    public GameModel() {
    }
    public GameModel(long id, String name, String category, int expertMark, String ageRange, String expertDefinition, String expertReview) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.expertMark = expertMark;
        this.ageRange = ageRange;
        this.expertDefinition = expertDefinition;
        this.expertReview = expertReview;
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

    public void setAvatarBytes(byte[] avatar) {
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
