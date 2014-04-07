package utils;


import components.Pelota;

public class YUpdater extends CoordinateUpdater {
    public YUpdater(Pelota pelota) {
        super(pelota);
    }

    @Override
    public int getDimentsionLimit() {
        return pelota.getScene().getGame().getDisplayHeight();
    }

    @Override
    public double getCoordinate(Pelota pelota) {
        return pelota.getY();
    }

    @Override
    public void setCoordinate(Pelota pelota, double newValue) {
        pelota.setY(newValue);
    }

    @Override
    public int getDirection(Pelota pelota) {
        return pelota.getDirectionY();
    }

    @Override
    public void setDirection(Pelota pelota, int newValue) {
        pelota.setDirectionY(newValue);
    }
}
