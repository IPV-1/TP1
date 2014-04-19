package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.colissions.Bounds;
import com.uqbar.vainilla.colissions.CollisionDetector;
import com.uqbar.vainilla.sound.Sound;

import resource.Resource;
import scenes.BasicArkanoidScene;
import utils.XUpdater;
import utils.YUpdater;


import java.awt.*;

public class Ball extends MovingGameComponent<BasicArkanoidScene> {

	public static final int INITIAL_SPEED = 200;
	protected static final Sound HIT_SOUND = Resource.getSound("ball_hit.wav");
	protected static final Sound LOSE_SOUND = Resource.getSound("ball_lose.wav");
	protected static final float VOLUME = 0.3f;
	

	public Ball(Color color, double xPos, double yPos, UnitVector2D direction) {
		super(Resource.getSprite("ball.png"), xPos, yPos, direction.getX(),
				direction.getY(), INITIAL_SPEED);
	}

	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		if (this.updateX(deltaState)) {
			this.bounceX();
			HIT_SOUND.play(VOLUME);
		}
		if (this.updateY(deltaState)) {
			if (this.getY() >= this.getScene().getGame().getDisplayHeight()) {
				this.getScene().lose();
				LOSE_SOUND.play(VOLUME);
			} else {
				this.bounceY();
				HIT_SOUND.play(VOLUME);
			}
		}

		this.getScene().verifyBallCollides(this);
	}

	public void collide(Collidable collidable) {
		GameComponent<?> component = collidable.asComponent();
		Bounds ballB = new Bounds(this);
		Bounds componentB = new Bounds(component);

		if (CollisionDetector.INSTANCE.isHorizontalCollision(ballB, componentB)) {
			if (ballB.getTop() < componentB.getTop()) {
				this.setY(component.getY() - this.getHeight() - 1);
			} else {
				this.setY(component.getY() + component.getHeight() + 1);
			}
			bounceY(collidable);
		} else {
			if (ballB.getLeft() < componentB.getLeft()) {
				this.setX(component.getX() - this.getWidth() - 1);
			} else {
				this.setX(component.getX() + component.getWidth() + 1);
			}
			bounceX();
		}
		HIT_SOUND.play(VOLUME);
	}

	public boolean updateX(DeltaState delta) {
		return XUpdater.INSTANCE.update(this);
	}

	public boolean updateY(DeltaState delta) {
		return YUpdater.INSTANCE.update(this);
	}

	public void bounceY(Collidable collidable) {
		collidable.bounceBallY(this);
	}

	public void bounceX() {
		uVector.invertX();
	}

	public void bounceY() {
		uVector.invertY();
	}

	public double getDiameter() {
		return this.getAppearance().getWidth();
	}

	public void placeOver(Platform platform) {
		this.setY(platform.getY() - this.getHeight() - 1);
	}

	public void speedUp(int i) {
		this.setSpeed(this.getSpeed() + i);
	}

	public void reset() {
		uVector = new UnitVector2D(1, -1);
		this.setSpeed(INITIAL_SPEED);
		((BasicArkanoidScene) this.getScene()).resetBallPosition();
	}

}
