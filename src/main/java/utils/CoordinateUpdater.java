package utils;

import com.uqbar.vainilla.DeltaState;
import components.Pelota;

/**
 * Abstract class for updating a Pelota coordinates and directions.
 */
public abstract class CoordinateUpdater {

    Pelota pelota;

    public CoordinateUpdater(Pelota pelota) {
        this.pelota = pelota;
    }

    public void update(DeltaState deltar) {
        this.setCoordinate(pelota, this.getCoordinate(pelota) + this.getDirection(pelota) * pelota.getVelocityFactor(deltar));
        if (this.getCoordinate(pelota) <= 0) {
            this.setCoordinate(pelota, 0);
            this.setDirection(pelota, -this.getDirection(pelota));
        } else if (this.getCoordinate(pelota) + pelota.getDiameter() >= getDimensionLimit()) {
            this.setCoordinate(pelota, getDimensionLimit() - pelota.getDiameter());
            this.setDirection(pelota, -this.getDirection(pelota));
        }
    }

    /**
     * Choose a better name
     */
    public abstract int getDimensionLimit();

    public abstract double getCoordinate(Pelota pelota);

    public abstract void setCoordinate(Pelota pelota, double newValue);

    public abstract int getDirection(Pelota pelota);

    public abstract void setDirection(Pelota pelota, int newValue);
}
