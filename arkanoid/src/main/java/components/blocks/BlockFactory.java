package components.blocks;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BlockFactory {

    private static int blockSeparation = 1;
    private static int initialTopSeparation = 80;
    private static int initialLeftSeparation = 18;

    private static java.util.List<Color> colors = Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.YELLOW);

    public static ArrayList<Block> blocks(int screenWidth, int upperLimit) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        int y = upperLimit + initialTopSeparation;
        for (Color color : colors) {
            blocks.addAll(blockRow(screenWidth, y, color));
            y += Block.HEIGHT + blockSeparation;
        }
        return blocks;
    }

    public static ArrayList<Block> blockRow(int screenWidth, int y, Color color) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        for (int x = initialLeftSeparation; x + Block.WIDTH < screenWidth; x += Block.WIDTH + blockSeparation) {
            blocks.add(new Block(color, x, y));
        }
        return blocks;
    }

    public static ArrayList<MultiLifeBlock> multiLifeBlocks(int screenWidth, int upperLimit) {
        ArrayList<MultiLifeBlock> blocks = new ArrayList<MultiLifeBlock>();
        int y = upperLimit + initialTopSeparation;
        for (Color color : colors) {
            blocks.addAll(multiLifeBlocksRow(screenWidth, y, color));
            y += Block.HEIGHT + blockSeparation;
        }
        return blocks;
    }

    public static ArrayList<MultiLifeBlock> multiLifeBlocksRow(int screenWidth, int y, Color color) {
        ArrayList<MultiLifeBlock> blocks = new ArrayList<MultiLifeBlock>();
        for (int x = initialLeftSeparation; x + Block.WIDTH < screenWidth; x += Block.WIDTH + blockSeparation) {
            blocks.add(new MultiLifeBlock(x, y));
        }
        return blocks;
    }


}
