package com.margin.game_guide_server.service;

import com.margin.game_guide_server.data.Database;
import com.margin.game_guide_server.model.GameModel;
import com.margin.game_guide_server.model.ReviewModel;
import com.margin.game_guide_server.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Martha on 5/1/2016.
 */
public class GameService {
    public static final String MATH_GAMES = "mathGames";
    public static final String PUZZLE_GAMES = "puzzleGames";
    public static final String ROLE_PLAYING_GAMES = "rolePlayingGames";

    public HashMap<Long, GameModel> pickCategoryMap(String category){
        HashMap<Long, GameModel> gameMap = new HashMap<>();
        HashMap<Long, GameModel> currentGameMap = Database.instance().getGameMap();
        ArrayList<GameModel> gameModels = new ArrayList<>(currentGameMap.values());
        for (GameModel currentGame : gameModels) {
            if(currentGame.getCategory().equals(category))
                gameMap.put(currentGame.getId(), currentGame);
        }
        return gameMap;
    }

    public GameModel getGame(String category, Long gameId){
        HashMap<Long, GameModel> currentCategoryMap = pickCategoryMap(category);
        GameModel currentGame = currentCategoryMap.get(gameId);
        if (currentGame == null) return null;
        return currentGame;
    }

    public ArrayList addReview(String category, Long gameId, UserModel userModel, String review){
        return pickCategoryMap(category).get(gameId).addReview(new ReviewModel(userModel, review));
    }

}
