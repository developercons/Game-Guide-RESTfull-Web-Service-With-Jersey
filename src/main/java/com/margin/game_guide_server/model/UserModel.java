package com.margin.game_guide_server.model;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Martha on 4/30/2016.
 */
@XmlRootElement
public class UserModel {
    @Expose
    private long id;
    @Expose
    private String first_name;
    @Expose
    private String last_name;
    @Expose
    private String email;
    @Expose
    private String phone;
    @Expose
    private String token;
    @Expose(serialize = false)
    private String password;
    @Expose(serialize = false)
    private String udid;

    private byte[] avatarBytes;

    private ArrayList<Integer> reviewedGameIdList;

    public String getFullName(){
        return first_name + " " + last_name;
    }

    public void addReviewedGame(Integer gameId){
        reviewedGameIdList.add(gameId);
    }

    public ArrayList<Integer> getReviewedGameIdList(){
        return reviewedGameIdList;
    }

    public void removeReviewedGame(Integer gameId){
        reviewedGameIdList.remove(gameId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public byte[] getAvatarBytes() {
        return avatarBytes;
    }

    public void setAvatarBytes(byte[] avatarBytes) {
        this.avatarBytes = avatarBytes;
    }
}
