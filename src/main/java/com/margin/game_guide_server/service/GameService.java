package com.margin.game_guide_server.service;

import com.margin.game_guide_server.data.Database;
import com.margin.game_guide_server.data.ImageLoader;
import com.margin.game_guide_server.enums.Category;
import com.margin.game_guide_server.model.GameModel;
import com.margin.game_guide_server.model.ReviewModel;
import com.margin.game_guide_server.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Martha on 5/1/2016.
 */
public class GameService {

    private HashMap<String, HashMap<Long, GameModel>> gameMap = Database.instance().getGameMap();
    private static long next_game_id = 0;

    public GameService() {
        init();
    }

    private void init(){
        Category[] category  = Category.values();
        for (int i = 0; i < category.length; i++) {
            gameMap.put(category[i].toString(), new HashMap<Long, GameModel>());
        }
        initGames();
    }

    private void initGames() {
        GameModel game1 = new GameModel(++next_game_id,
                "Dragon Fly", Category.ROLE_PLAYING.toString(), 3, "12+", "Good time killer",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game2 = new GameModel(++next_game_id,
                "Dragon Fly", Category.ROLE_PLAYING.toString(), 4, "12+", "Good time killer",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game3 = new GameModel(++next_game_id,
                "Dragon Fly", Category.ROLE_PLAYING.toString(), 2, "12+", "Good time killer",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game4 = new GameModel(++next_game_id,
                "Dragon Fly", Category.ROLE_PLAYING.toString(), 1, "12+", "Good time killer",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game5 = new GameModel(++next_game_id,
                "Dragon Fly", Category.ROLE_PLAYING.toString(), 3, "12+", "Good time killer",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game6 = new GameModel(++next_game_id,
                "Dragon Fly", Category.ROLE_PLAYING.toString(), 3, "12+", "Good time killer",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game7 = new GameModel(++next_game_id,
                "Dragon Fly", Category.ROLE_PLAYING.toString(), 5, "12+", "Good time killer",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game8 = new GameModel(++next_game_id,
                "BrainBalls", Category.MATH_GAMES.toString(), 0, "1+", "TUFTA game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game9= new GameModel(++next_game_id,
                "BrainBalls", Category.MATH_GAMES.toString(), 5, "1+", "Good good game!",
                "This game is a pretty good time killer. Has a fair design.");

        ArrayList<GameModel> gameModels = new ArrayList<>();
        gameModels.add(game1);
        gameModels.add(game2);
        gameModels.add(game3);
        gameModels.add(game4);
        gameModels.add(game5);
        gameModels.add(game6);
        gameModels.add(game7);
        gameModels.add(game8);
        gameModels.add(game9);

        ImageLoader.loadImages(gameModels);

        for(GameModel g : gameModels){
            gameMap.get(g.getCategory()).put(g.getId(), g);
        }
    }


    public void addGame(String category, GameModel game){
        gameMap.get(category).put(game.getId(), game);
    }

    public GameModel getAGame(String category, Long gameId){
       return gameMap.get(category).get(gameId);
    }

    public Set<Long> getGameIdListByCategory(String category){
        return gameMap.get(category).keySet();
    }

    public ArrayList addReview(String category, Long gameId, UserModel userModel, String review){
        return gameMap.get(category).get(gameId).addReview(new ReviewModel(userModel, review));
    }

    public Set<String> getCategoryList(){
        return gameMap.keySet();
    }

}
