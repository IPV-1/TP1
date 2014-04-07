package utils;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Appearance;

/**
 * GameComponent with velocity (speed and unit vector)
 */
public class MovingGameComponent extends GameComponent<GameScene> {

	protected UnitVector2D uVector;
	protected double speed;

	public MovingGameComponent() {
		super();
		this.uVector = new UnitVector2D(1, 1);
		this.speed = 0;
	}

	public MovingGameComponent(double xPos, double yPos, double xVec,
			double yVec, double speed) {
		super(xPos, yPos);
		this.uVector = new UnitVector2D(xVec, yVec);
		this.speed = speed;
	}

	public MovingGameComponent(Appearance appearance, double xPos, double yPos,
			double xVec, double yVec, double speed) {
		super(appearance, xPos, yPos);
		this.uVector = new UnitVector2D(xVec, yVec);
		this.speed = speed;
	}

	@Override
	public void update(DeltaState deltaState) {
		double xPosition = this.getX() + this.getUVector().getX()
				* this.getVelocityFactor(deltaState);
		double yPosition = this.getY() + this.getUVector().getY()
				* this.getVelocityFactor(deltaState);
		this.setX(xPosition);
		this.setY(yPosition);
		this.bounce(xPosition, 0, this.getGame().getDisplayWidth(), true);
		this.bounce(yPosition, 0, this.getGame().getDisplayHeight(), false);
		super.update(deltaState);
	}

	public void bounce(double position, double from, double to, boolean isXValue) {
		double dimension = isXValue ? this.getAppearance().getWidth() : this
				.getAppearance().getHeight();
		double fromPosition = position;
		double toPosition = fromPosition + dimension;
		while (fromPosition < from || toPosition > to) {
			double newValue = fromPosition < from ? from : to - dimension;
			newValue = 2 * newValue - fromPosition;
			this.setAndInvert(newValue, isXValue);
			fromPosition = newValue;
			toPosition = fromPosition + dimension;
		}
	}

	protected void setAndInvert(double newValue, boolean isXValue) {
		if (isXValue) {
			this.setX(newValue);
			this.getUVector().invertX();
		} else {
			this.setY(newValue);
			this.getUVector().invertY();
		}
	}

	public double getVelocityFactor(DeltaState deltaState) {
		return this.getSpeed() * deltaState.getDelta();
	}

	public double getSpeed() {
		return this.speed;
	}

	public UnitVector2D getUVector() {
		return this.uVector;
	}

}
