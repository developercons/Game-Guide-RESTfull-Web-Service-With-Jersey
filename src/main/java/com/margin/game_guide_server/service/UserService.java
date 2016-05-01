package com.margin.game_guide_server.service;

import com.margin.game_guide_server.data.DataBase;
import com.margin.game_guide_server.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by Martha on 4/30/2016.
 */
public class UserService {

    private HashMap<String, UserModel> userMap = DataBase.instance().getUserMap();
    private HashMap<String, String> mailMap = DataBase.instance().getMailMap();
    private long userId;

    public UserModel createUser(UserModel user){
        String email = user.getEmail();
        user.setId(generateId());
        assignToken(user);
        userMap.put(email, user);
        return user;
    }
    public List<UserModel> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public UserModel login(UserModel userModel){
        if(!userExists(userModel) || !userModel.getPassword().equals(getUserByEmail(userModel.getEmail()).getPassword()))
            return null;
        UserModel currentUser = getUserByEmail(userModel.getEmail());
        if(currentUser.getToken() == null) assignToken(currentUser);
        return currentUser;
    }

    private void assignToken(UserModel user){
        String email = user.getEmail();
        String token = generateAccessToken();
        user.setToken(token);
        mailMap.put(token, email);
    }



    public boolean userExists(UserModel userModel){
        return userMap.containsKey(userModel.getEmail());
    }

    public UserModel getUserByEmail(String email){
        return userMap.get(email);
    }

    public UserModel getUserByToken(String token){
        if(mailMap.get(token) == null) return null;
        return userMap.get(mailMap.get(token));
    }

    public String generateAccessToken(){
        return UUID.randomUUID().toString();
    }

    public long generateId(){
        return ++userId;
    }
}
