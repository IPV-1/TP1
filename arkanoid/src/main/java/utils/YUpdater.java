package utils;


import components.Ball;

public class YUpdater extends CoordinateUpdater {
    public YUpdater(Ball ball) {
        super(ball);
    }

    @Override
    public int getDimensionLimit() {
        return ball.getScene().getGame().getDisplayHeight();
    }

    @Override
    public double getCoordinate(Ball ball) {
        return ball.getY();
    }

    @Override
    public void setCoordinate(Ball ball, double newValue) {
        ball.setY(newValue);
    }

    @Override
    public void changeDirection(Ball ball) {
        ball.boundY();
    }
}
