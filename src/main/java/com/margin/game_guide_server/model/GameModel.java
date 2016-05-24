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
    private int expert_mark;
    @Expose
    private String age_range;
    @Expose
    private String expert_definition;
    @Expose
    private String expert_review;

    private ArrayList<ReviewModel> reviews = new ArrayList<>();


    private byte[] avatar;

    public GameModel() {
    }
    public GameModel(long id, String name, String category, int expert_mark, String age_range, String expert_definition, String expert_review) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.expert_mark = expert_mark;
        this.age_range = age_range;
        this.expert_definition = expert_definition;
        this.expert_review = expert_review;
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

    public int getExpert_mark() {
        return expert_mark;
    }

    public void setExpert_mark(int expert_mark) {
        this.expert_mark = expert_mark;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }

    public String getExpert_definition() {
        return expert_definition;
    }

    public void setExpert_definition(String expert_definition) {
        this.expert_definition = expert_definition;
    }

    public String getExpert_review() {
        return expert_review;
    }

    public void setExpert_review(String expert_review) {
        this.expert_review = expert_review;
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
