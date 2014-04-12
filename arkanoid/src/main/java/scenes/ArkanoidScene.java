package scenes;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.Ball;
import components.Block;
import components.Platform;
import components.ScoreBoard;

public class ArkanoidScene extends GameScene {
	
	private ScoreBoard scoreBoard = new ScoreBoard(10, 5, Color.black);

	public ArkanoidScene(Game game) {
		super();

		this.setGame(game);
		this.addComponent(new Ball(Color.black, 50, 100, 390, 1, 1, 2500));
		this.addComponent(new Platform(Color.blue, 100, 10, 20, 580));
		this.addComponent(this.getScoreBoard());
		this.addBlocks();
	}
	
	public void verifyBallCollides(Ball ball) {
		for (GameComponent<?> component : this.getComponents()) {
			if(component != ball &&
				CollisionDetector.INSTANCE.collidesCircleAgainstRect(ball.getCirc(), component.getRect())) {
				
				// Notify collides ball with component
				ball.collide(component);
				component.collide(ball);
			}
		}
	}

	protected void addBlocks() {
		final int WIDTH = this.getGame().getDisplayWidth();
		int y = 50;
		List<Color> colors = Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.YELLOW,
				Color.BLUE, Color.MAGENTA, Color.GREEN);
		for (int i = 0; i < colors.size(); i++, y += Block.HEIGHT + 1) {
			for (int x = 18; x + Block.WIDTH < WIDTH; x += Block.WIDTH + 1) {
				this.addComponent(new Block(colors.get(i), x, y));
			}
		}
	}

	public void addScore(int value) {
		this.getScoreBoard().add(value);
	}

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

}
