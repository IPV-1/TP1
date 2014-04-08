package utils;


import components.Ball;

public class XUpdater extends CoordinateUpdater {

    public XUpdater(Ball ball) {
        super(ball);
    }

    @Override
    public int getDimensionLimit() {
        return ball.getScene().getGame().getDisplayWidth();
    }

    @Override
    public double getCoordinate(Ball ball) {
        return ball.getX();
    }

    @Override
    public void setCoordinate(Ball ball, double newValue) {
        ball.setX(newValue);
    }

    @Override
    public void changeDirection(Ball ball) {
        ball.boundX();
    }


}
