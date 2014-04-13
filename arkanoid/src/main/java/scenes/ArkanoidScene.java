package scenes;

import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.Ball;
import components.Platform;
import components.ScoreBoard;
import components.blocks.BlockFactory;
import utils.YUpdater;

import java.awt.*;

public class ArkanoidScene extends GameScene {
	
	private ScoreBoard scoreBoard = new ScoreBoard(10, 5, Color.black);
	private Platform platform = new Platform(Color.blue, 10, 20, 580);
	private Ball ball = new Ball(Color.black, 100, 390, new UnitVector2D(1, -1), 200);

	public ArkanoidScene(Game game) {
		super();

		this.setGame(game);
		this.addComponent(this.getScoreBoard());
		this.addBlocks();
		this.addComponent(platform);
		platform.center();
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
        BlockFactory.addBlocks(this, YUpdater.UPPER_LIMIT);
	}
	
	public void lose() {
		this.getGame().setCurrentScene(new LoseScene(this.getGame()));
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
