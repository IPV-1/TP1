package utils;

import com.uqbar.vainilla.MovingGameComponent;

public class YUpdater extends CoordinateUpdater {

	public static final YUpdater INSTANCE = new YUpdater();
	
	protected YUpdater(){}

	@Override
	public int getDimensionLimit(MovingGameComponent component) {
		return component.getScene().getGame().getDisplayHeight();
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
