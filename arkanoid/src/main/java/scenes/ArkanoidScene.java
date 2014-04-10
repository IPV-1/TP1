package scenes;

import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameScene;
import components.Ball;
import components.Block;
import components.Platform;

import java.awt.Color;
import java.util.List;
import java.util.Arrays;

public class ArkanoidScene extends GameScene {

	public ArkanoidScene(Game game) {
		super();
		this.setGame(game);
		this.addComponent(new Ball(Color.black, 50, 100, 390, 1, 1, 100));
		this.addComponent(new Platform(Color.blue, 100, 10, 20, 580));
		this.addBlocks();
	}

	protected void addBlocks() {
		final int WIDTH = this.getGame().getDisplayWidth();
		int y = 50;
		List<Color> colors = Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.YELLOW,
				Color.BLUE, Color.MAGENTA, Color.GREEN);
		for (int i = 0; i < colors.size(); i++, y += Block.HEIGHT + 1) {
			for (int x = 0; x + Block.WIDTH < WIDTH; x += Block.WIDTH + 1) {
				this.addComponent(new Block(colors.get(i), x, y));
			}
		}
	}

}
