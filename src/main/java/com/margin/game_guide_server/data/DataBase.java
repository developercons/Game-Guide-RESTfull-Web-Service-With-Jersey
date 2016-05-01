package com.margin.game_guide_server.data;

import com.margin.game_guide_server.model.UserModel;

import java.util.HashMap;

/**
 * Created by Martha on 4/30/2016.
 */
public class DataBase {
    private static DataBase instance = new DataBase();

    private HashMap<String, UserModel> userMap;
    private HashMap<String, String> mailMap;


    private DataBase() {
        userMap = new HashMap<>();
        mailMap = new HashMap<>();
    }

    public HashMap<String, UserModel> getUserMap() {
        return userMap;
    }

    public HashMap<String, String> getMailMap() {
        return mailMap;
    }

    public static DataBase instance() {
        return instance;
    }
}
