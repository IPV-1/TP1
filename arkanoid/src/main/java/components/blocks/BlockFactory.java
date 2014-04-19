package components.blocks;

import img.Resource;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.uqbar.vainilla.appearances.Sprite;

public class BlockFactory {

	private final static int LATERAL_SEPARATION = 35;
	private static int blockSeparation = 1;
	private static int initialTopSeparation = 70;
	private static int initialLeftSeparation = 33 + LATERAL_SEPARATION;

	public static final Sprite RED = Resource.getSprite("block_red.png");
	public static final Sprite BLUE = Resource.getSprite("block_blue.png");
	public static final Sprite GREEN = Resource.getSprite("block_green.png");
	public static final Sprite YELLOW = Resource.getSprite("block_yellow.png");

	private static java.util.List<Color> colors = Arrays.asList(Color.YELLOW,
			Color.ORANGE, Color.RED);
	private static java.util.List<Sprite> sprites = Arrays.asList(BLUE, GREEN);

	public static ArrayList<Block> blocks(int screenWidth, int upperLimit) {
		ArrayList<Block> blocks = new ArrayList<Block>();
		int y = upperLimit + initialTopSeparation;
		for (Sprite sprite : sprites) {
			blocks.addAll(blockRow(screenWidth, y, sprite));
			y += Block.HEIGHT + blockSeparation;
		}
		return blocks;
	}

	public static ArrayList<Block> blockRow(int screenWidth, int y,
			Sprite sprite) {
		ArrayList<Block> blocks = new ArrayList<Block>();
		for (int x = initialLeftSeparation; x + Block.WIDTH < screenWidth
				- LATERAL_SEPARATION; x += Block.WIDTH + blockSeparation) {
			blocks.add(new Block(sprite, x, y));
		}
		return blocks;
	}

	public static ArrayList<MultiLifeBlock> multiLifeBlocks(int screenWidth,
			int upperLimit) {
		ArrayList<MultiLifeBlock> blocks = new ArrayList<MultiLifeBlock>();
		int y = upperLimit + initialTopSeparation;
		for (Color color : colors) {
			blocks.addAll(multiLifeBlocksRow(screenWidth, y, color));
			y += Block.HEIGHT + blockSeparation;
		}
		return blocks;
	}

	public static ArrayList<MultiLifeBlock> multiLifeBlocksRow(int screenWidth,
			int y, Color color) {
		ArrayList<MultiLifeBlock> blocks = new ArrayList<MultiLifeBlock>();
		for (int x = initialLeftSeparation; x + Block.WIDTH < screenWidth
				- LATERAL_SEPARATION; x += Block.WIDTH + blockSeparation) {
			blocks.add(new MultiLifeBlock(x, y));
		}
		return blocks;
	}

}
