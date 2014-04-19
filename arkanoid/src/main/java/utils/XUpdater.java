package utils;

import com.uqbar.vainilla.MovingGameComponent;

public class XUpdater extends CoordinateUpdater {

	public static final XUpdater INSTANCE = new XUpdater();
	
	public static final int LIMIT = 35;
	
	protected XUpdater(){}

	@Override
	public int getDimensionLimit(MovingGameComponent component) {
		return component.getScene().getGame().getDisplayWidth() - LIMIT;
	}
	
	@Override
	public int getDimensionFrom(MovingGameComponent component) {
		return LIMIT;
	}

	@Override
	public double getCoordinate(MovingGameComponent component) {
		return component.getX();
	}

	@Override
	public void setCoordinate(MovingGameComponent component, double newValue) {
		component.setX(newValue);
	}

	public double getDimension(MovingGameComponent component) {
		return component.getWidth();
	}

}
