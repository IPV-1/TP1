package utils;

import com.uqbar.vainilla.MovingGameComponent;

/**
 * Abstract class for updating a MovingGameComponent coordinates.
 */
public abstract class CoordinateUpdater {

	public boolean update(MovingGameComponent comp) {
		boolean updated = false;
		if (this.getCoordinate(comp) <= this.getDimensionFrom(comp)) {
			this.setCoordinate(comp, this.getDimensionFrom(comp));
			updated = true;
		} else if (this.getCoordinate(comp) + this.getDimension(comp) >= getDimensionLimit(comp)) {
			this.setCoordinate(comp, getDimensionLimit(comp) - this.getDimension(comp));
			updated = true;
		}
		return updated;
	}

	/**
	 * Choose a better name
	 */
	public abstract int getDimensionLimit(MovingGameComponent component);
	public abstract int getDimensionFrom(MovingGameComponent component);
	

	public abstract double getCoordinate(MovingGameComponent component);

	public abstract void setCoordinate(MovingGameComponent component, double newValue);

	public abstract double getDimension(MovingGameComponent component);

}
