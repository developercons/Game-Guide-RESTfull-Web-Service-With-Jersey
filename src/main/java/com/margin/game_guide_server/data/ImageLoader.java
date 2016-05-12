package com.margin.game_guide_server.data;

import com.margin.game_guide_server.model.GameModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Lion on 5/11/16.
 */
public class ImageLoader {
    static final File dir = new File(Paths.get("").toAbsolutePath().toString() + "/assets/game");
    static final String[] EXTENSIONS = new String[] { "png" };
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public static void loadImages(List<GameModel> allGames) {

        if (dir.isDirectory()) { // make sure it's a directory
            File[] files = dir.listFiles(IMAGE_FILTER);
            for (final File f : files) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(f);
                    String gameName = f.getName();
                    gameName = gameName.substring(0, gameName.length() - 4); // "don't need the extensions".
                    long correspondingGameId = Long.parseLong(gameName);
                    GameModel game = getGameWithId(allGames, correspondingGameId);
                    if (game == null) throw new RuntimeException("No game with id corresponding to the image name.");
                    byte[] imageBytes = bufferedImageToBytes(img);
                    game.setAvatarBytes(imageBytes);
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static byte[] bufferedImageToBytes(BufferedImage image) {
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            baos.close();
            return baos.toByteArray();
        }catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    static GameModel getGameWithId(List<GameModel> gameList, long id) {
        for (GameModel game : gameList) {
            if (game.getId() == id)
                return game;
        }
        return null;
    }


}
