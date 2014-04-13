package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.Bounds;
import com.uqbar.vainilla.colissions.CollisionDetector;
import scenes.ArkanoidScene;
import utils.XUpdater;
import utils.YUpdater;

import java.awt.*;

public class Ball extends MovingGameComponent {

	public static final int DIAMETER = 20;

	public Ball(Color color, double xPos, double yPos, UnitVector2D direction,
			double speed) {
		super(new Circle(color, Ball.DIAMETER), xPos, yPos, direction.getX(),
				direction.getY(), speed);
	}

	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		if (this.updateX(deltaState)) {
			this.bounceX();
		}
        if (this.updateY(deltaState)) {
            if (this.getY() >= this.getScene().getGame().getDisplayHeight()) {
                ((ArkanoidScene) this.getScene()).lose();
            } else {
                this.bounceY();
            }
        }

		((ArkanoidScene) this.getScene()).verifyBallCollides(this);
	}

	public void collide(Collidable collidable) {
        //TODO: Remove the (Cast)
        GameComponent<?> component = (GameComponent<?>) collidable;
		Bounds ballB = new Bounds(this);
		Bounds componentB = new Bounds(component);

		if (CollisionDetector.INSTANCE.isHorizontalCollision(ballB, componentB)) {
			if (ballB.getTop() < componentB.getTop()) {
				this.setY(component.getY() - this.getHeight() - 1);
			} else {
				this.setY(component.getY() + component.getHeight() + 1);
			}
			bounceY( component);
		} else {
			if (ballB.getLeft() < componentB.getLeft()) {
				this.setX(component.getX() - this.getWidth() - 1);
			} else {
				this.setX(component.getX() + component.getWidth() + 1);
			}
			bounceX();
		}
	}

	public boolean updateX(DeltaState delta) {
		return XUpdater.INSTANCE.update(this);
	}

	public boolean updateY(DeltaState delta) {
		return YUpdater.INSTANCE.update(this);
	}

	public void bounceY(GameComponent<?> component) {
		if (component.getClass() == Platform.class) {
			final double LIMIT = 0.65;
			double dif = (this.getX() - component.getX()) / Platform.WIDTH * LIMIT;
			this.getUVector().setPI(dif - 1 + (1 - LIMIT) / 2);
		} else {
			uVector.invertY();
		}
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

}
