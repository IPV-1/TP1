package components.blocks;


import com.uqbar.vainilla.GameScene;

import java.awt.*;
import java.util.Arrays;

public class BlockFactory {

    private static int blockSeparation = 1;
    private static int initialTopSeparation = 80;
    private static int initialLeftSeparation = 18;

    private static java.util.List<Color> colors = Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.MAGENTA, Color.GREEN);

    public static void addBlocks(GameScene scene, int upperLimit) {
        int screenWidth = scene.getGame().getDisplayWidth();
        int y = upperLimit + initialTopSeparation;
        for (Color color : colors) {
            addBlockRow(scene, screenWidth, y, color);
            y += Block.HEIGHT + blockSeparation;
        }
    }

    public static void addBlockRow(GameScene scene, int screenWidth, int y, Color color) {

        for (int x = initialLeftSeparation; x + Block.WIDTH < screenWidth; x += Block.WIDTH + blockSeparation) {
            scene.addComponent(new Block(color, x, y));
        }
    }


}
