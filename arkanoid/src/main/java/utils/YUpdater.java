package utils;

import com.uqbar.vainilla.MovingGameComponent;
import components.Ball;

public class YUpdater extends CoordinateUpdater {

	public static final YUpdater INSTANCE = new YUpdater();
	public static final int UPPER_LIMIT = 50;
	
	protected YUpdater(){}

	@Override
	public int getDimensionLimit(MovingGameComponent component) {
		return component.getScene().getGame().getDisplayHeight() + Ball.DIAMETER;
	}
	
	@Override
	public int getDimensionFrom(MovingGameComponent component) {
		return 0 + YUpdater.UPPER_LIMIT;
	}

	@Override
	public double getCoordinate(MovingGameComponent component) {
		return component.getY();
	}

	@Override
	public void setCoordinate(MovingGameComponent component, double newValue) {
		component.setY(newValue);
	}

	public double getDimension(MovingGameComponent component) {
		return component.getHeight();
	}
	
}
