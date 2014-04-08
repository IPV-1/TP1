package utils;

import com.uqbar.vainilla.DeltaState;
import components.Ball;

/**
 * Abstract class for updating a Ball coordinates and directions.
 */
public abstract class CoordinateUpdater {

    Ball ball;

    public CoordinateUpdater(Ball ball) {
        this.ball = ball;
    }

    public void update(DeltaState deltar) {
        if (this.getCoordinate(ball) <= 0) {
            this.setCoordinate(ball, 0);
            this.changeDirection(ball);
        } else if (this.getCoordinate(ball) + ball.getDiameter() >= getDimensionLimit()) {
            this.setCoordinate(ball, getDimensionLimit() - ball.getDiameter());
            this.changeDirection(ball);
        }
    }

    /**
     * Choose a better name
     */
    public abstract int getDimensionLimit();

    public abstract double getCoordinate(Ball ball);

    public abstract void setCoordinate(Ball ball, double newValue);

    public abstract void changeDirection(Ball ball);
}
