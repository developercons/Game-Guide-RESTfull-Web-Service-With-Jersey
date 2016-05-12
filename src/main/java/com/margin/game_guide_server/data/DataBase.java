package com.margin.game_guide_server.data;

import com.margin.game_guide_server.model.GameModel;
import com.margin.game_guide_server.model.UserModel;

import java.util.HashMap;

/**
 * Created by Martha on 4/30/2016.
 */
public class Database {
    private static Database instance = new Database();

    private HashMap<String, UserModel> userMap; // Email - User
    private HashMap<String, String> mailMap; // Token - Email
    private HashMap<String, HashMap<Long, GameModel>> gameMap; // Category - Game ID - Game Model


    private Database() {
        userMap = new HashMap<>();
        mailMap = new HashMap<>();
        gameMap = new HashMap<>();
    }

    public HashMap<String, UserModel> getUserMap() {
        return userMap;
    }

    public HashMap<String, String> getMailMap() {
        return mailMap;
    }

    public HashMap<String, HashMap<Long, GameModel>> getGameMap() {
        return gameMap;
    }

    public static Database instance() {
        return instance;
    }
}
