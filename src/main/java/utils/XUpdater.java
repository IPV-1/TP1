package utils;


import components.Pelota;

public class XUpdater extends CoordinateUpdater {

    public XUpdater(Pelota pelota) {
        super(pelota);
    }

    @Override
    public int getDimentsionLimit() {
        return pelota.getScene().getGame().getDisplayWidth();
    }

    @Override
    public double getCoordinate(Pelota pelota) {
        return pelota.getX();
    }

    @Override
    public void setCoordinate(Pelota pelota, double newValue) {
        pelota.setX(newValue);
    }

    @Override
    public int getDirection(Pelota pelota) {
        return pelota.getDirectionX();
    }

    @Override
    public void setDirection(Pelota pelota, int newValue) {
        pelota.setDirectionX(newValue);
    }
}
