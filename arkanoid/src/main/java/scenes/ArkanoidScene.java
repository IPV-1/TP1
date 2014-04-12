package scenes;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import utils.YUpdater;

import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.Ball;
import components.Block;
import components.Platform;
import components.ScoreBoard;

public class ArkanoidScene extends GameScene {
	
	private ScoreBoard scoreBoard = new ScoreBoard(10, 5, Color.black);
	private Platform platform = new Platform(Color.blue, 10, 508, 580);
	private Ball ball = new Ball(Color.black, 100, 390, new UnitVector2D(1, -1), 200);

	public ArkanoidScene(Game game) {
		super();

		this.setGame(game);
		this.addComponent(this.getScoreBoard());
		this.addBlocks();
		this.addComponent(platform);
//		platform.center();
		this.addComponent(ball);
		ball.center();
		ball.placeOver(platform);
	}
	
	public void verifyBallCollides(Ball ball) {
		for (GameComponent<?> component : this.getComponents()) {
			if(component != ball && component != scoreBoard &&
				CollisionDetector.INSTANCE.collidesCircleAgainstRect(ball.getCirc(), component.getRect())) {
				
				// Notify collides ball with component
				ball.collide(component);
				component.collide(ball);
			}
		}
		if(this.getComponentCount() == 3) {
			this.win();
		}
	}

	protected void addBlocks() {
		final int WIDTH = this.getGame().getDisplayWidth();
		int y = YUpdater.UPPER_LIMIT + 80;
		List<Color> colors = Arrays.asList(
				//TODO uncomment when finish debugging
				//Color.LIGHT_GRAY, Color.RED, Color.YELLOW,
				Color.BLUE, Color.MAGENTA, Color.GREEN);
		for (int i = 0; i < colors.size(); i++, y += Block.HEIGHT + 1) {
			for (int x = 18; x + Block.WIDTH < WIDTH; x += Block.WIDTH + 1) {
				this.addComponent(new Block(colors.get(i), x, y));
			}
		}
	}
	
	public void lose() {
		//TODO uncomment when finish debugging
		//this.getGame().setCurrentScene(new LoseScene(this.getGame()));
	}
	
	public void win() {
		this.getGame().setCurrentScene(new WinScene(this.getGame()));
	}

	public void addScore(int value) {
		this.getScoreBoard().add(value);
	}
	
	public void speedUp(int value) {
		this.getBall().speedUp(value);
		// Increment platform speed??
	}

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}
	
	public Ball getBall() {
		return ball;
	}
}
