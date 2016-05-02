package com.margin.game_guide_server.service;

import com.margin.game_guide_server.data.DataBase;
import com.margin.game_guide_server.model.GameModel;
import com.margin.game_guide_server.model.ReviewModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Martha on 5/1/2016.
 */
public class GameService {
    public static final String MATH_GAMES = "mathGames";
    public static final String PUZZLE_GAMES = "puzzleGames";
    public static final String ROLE_PLAYING_GAMES = "rolePlayingGames";
    private HashMap<Long, GameModel> gameMap;


    public HashMap<Long, GameModel> pickCategoryMap(String category){
        switch (category){
            case MATH_GAMES:
                gameMap = DataBase.instance().getMathGameMap();
                break;
            case PUZZLE_GAMES:
                gameMap = DataBase.instance().getPuzzleGameMap();
                break;
            case ROLE_PLAYING_GAMES:
                gameMap = DataBase.instance().getRolePlayingGameMap();
        }
         return gameMap;
    }

    public GameModel getGame(String category, Long gameId){
        HashMap<Long, GameModel> currentCategoryMap = pickCategoryMap(category);
        GameModel currentGame = currentCategoryMap.get(gameId);
        if (currentGame == null) return null;
        return currentGame;
    }

    public ArrayList addReview(String category, Long gameId, String userToken, String review){
        return pickCategoryMap(category).get(gameId).addReview(new ReviewModel(userToken, review));
    }

}
