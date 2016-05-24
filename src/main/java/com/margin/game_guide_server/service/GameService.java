package com.margin.game_guide_server.service;

import com.margin.game_guide_server.data.Database;
import com.margin.game_guide_server.enums.Category;
import com.margin.game_guide_server.model.GameModel;
import com.margin.game_guide_server.model.ReviewModel;
import com.margin.game_guide_server.model.UserModel;
import com.margin.game_guide_server.util.Util;

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
                "Age of Civilizations", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game2 = new GameModel(++next_game_id,
                "Chess Free", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game3 = new GameModel(++next_game_id,
                "Subterfuge", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game4 = new GameModel(++next_game_id,
                "Templar Battleforce", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game5 = new GameModel(++next_game_id,
                "Starhammer", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game6 = new GameModel(++next_game_id,
                "Rebuild 3", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game7 = new GameModel(++next_game_id,
                "Door Kickers", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game8 = new GameModel(++next_game_id,
                "XCOM: Enemy Within", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game9= new GameModel(++next_game_id,
                "Civilization Revolution 2", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game10= new GameModel(++next_game_id,
                "The Banner Saga", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game11= new GameModel(++next_game_id,
                "Heroes of Warcraft", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game12= new GameModel(++next_game_id,
                "Frozen Synapse", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game13= new GameModel(++next_game_id,
                "War of the Lions", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game14= new GameModel(++next_game_id,
                "Clash of Clans", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game15= new GameModel(++next_game_id,
                "Autumn Dynasty", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game16= new GameModel(++next_game_id,
                "Out There", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game17= new GameModel(++next_game_id,
                "Plague", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game18= new GameModel(++next_game_id,
                "BrainBalls", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good Game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game19= new GameModel(++next_game_id,
                "Eufloria", Category.STRATEGY.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game20= new GameModel(++next_game_id,
                "Kingdom Rush", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game21= new GameModel(++next_game_id,
                "Plants Vs Zombies", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game22= new GameModel(++next_game_id,
                "Defense Pacific", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game23= new GameModel(++next_game_id,
                "Fieldrunners 2", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game24= new GameModel(++next_game_id,
                "Royal Revolt II", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game25= new GameModel(++next_game_id,
                "Star Wars Galactic Defense", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game26= new GameModel(++next_game_id,
                "Alien Creeps", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game27= new GameModel(++next_game_id,
                "Defenders", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game28= new GameModel(++next_game_id,
                "Infinite War", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game29= new GameModel(++next_game_id,
                "geoDefense Swarm", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game30= new GameModel(++next_game_id,
                "Bloons TD 5", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game31= new GameModel(++next_game_id,
                "Anomaly 2", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game32= new GameModel(++next_game_id,
                "Defense Zone", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game33= new GameModel(++next_game_id,
                "Epic War", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game34= new GameModel(++next_game_id,
                "Anomaly Defenders", Category.TOWER_DEFENCE.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game35= new GameModel(++next_game_id,
                "Pocket Mortys", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game36= new GameModel(++next_game_id,
                "Attack The Light", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game37= new GameModel(++next_game_id,
                "Dragonfall Crashlands", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game38= new GameModel(++next_game_id,
                "Final Fantasy", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game39= new GameModel(++next_game_id,
                "Dragon Quest", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game40= new GameModel(++next_game_id,
                "Xperia", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game41= new GameModel(++next_game_id,
                "Chaos Rings", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game42= new GameModel(++next_game_id,
                "Zenonia", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game43= new GameModel(++next_game_id,
                "Brave Trials", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game44= new GameModel(++next_game_id,
                "Symphony of the Origin", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game45= new GameModel(++next_game_id,
                "Doom & Destiny", Category.ROLE_PLAYING.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game46= new GameModel(++next_game_id,
                "Super Why!", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game47= new GameModel(++next_game_id,
                "Polar Bowler!", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game48= new GameModel(++next_game_id,
                "Cut the Rope", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game49= new GameModel(++next_game_id,
                "Angry Birds", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game50= new GameModel(++next_game_id,
                "Shapes", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game51= new GameModel(++next_game_id,
                "Free Books", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game52= new GameModel(++next_game_id,
                "Memory Matches", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game53= new GameModel(++next_game_id,
                "GazziliScience", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game54= new GameModel(++next_game_id,
                "Ubooly", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game55= new GameModel(++next_game_id,
                "Mini Monet", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game56= new GameModel(++next_game_id,
                "Artkive", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game57= new GameModel(++next_game_id,
                " My First Classical Music App", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
                "This game is a pretty good time killer. Has a fair design.");
        GameModel game58= new GameModel(++next_game_id,
                "Art of Glow", Category.KIDS.toString(), Util.rand.nextInt(6) + 2, (Util.rand.nextInt(12) + 3) + "+ years old", "Good game!",
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
        gameModels.add(game10);
        gameModels.add(game11);
        gameModels.add(game12);
        gameModels.add(game13);
        gameModels.add(game14);
        gameModels.add(game15);
        gameModels.add(game16);
        gameModels.add(game17);
        gameModels.add(game18);
        gameModels.add(game19);
        gameModels.add(game20);
        gameModels.add(game21);
        gameModels.add(game22);
        gameModels.add(game23);
        gameModels.add(game24);
        gameModels.add(game25);
        gameModels.add(game26);
        gameModels.add(game27);
        gameModels.add(game28);
        gameModels.add(game29);
        gameModels.add(game30);
        gameModels.add(game31);
        gameModels.add(game32);
        gameModels.add(game33);
        gameModels.add(game34);
        gameModels.add(game35);
        gameModels.add(game36);
        gameModels.add(game37);
        gameModels.add(game38);
        gameModels.add(game39);
        gameModels.add(game40);
        gameModels.add(game41);
        gameModels.add(game42);
        gameModels.add(game43);
        gameModels.add(game44);
        gameModels.add(game45);
        gameModels.add(game46);
        gameModels.add(game47);
        gameModels.add(game48);
        gameModels.add(game49);
        gameModels.add(game50);
        gameModels.add(game51);
        gameModels.add(game52);
        gameModels.add(game53);
        gameModels.add(game54);
        gameModels.add(game55);
        gameModels.add(game56);
        gameModels.add(game57);
        gameModels.add(game58);
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
