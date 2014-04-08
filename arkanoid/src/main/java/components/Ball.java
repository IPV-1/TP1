package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Circle;
import utils.MovingGameComponent;
import utils.XUpdater;
import utils.YUpdater;

import java.awt.*;

public class Ball extends MovingGameComponent {

    public Ball(Color color, int diameter, double xPos, double yPos, double xVec,
                double yVec, double speed) {
        super(new Circle(color, diameter), xPos, yPos, xVec, yVec, speed);
    }

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        this.updateX(deltaState);
        this.updateY(deltaState);
    }

    public void updateX(DeltaState delta){
        new XUpdater(this).update(delta);
    }

    public void updateY(DeltaState delta){
        new YUpdater(this).update(delta);
    }

    public void boundX() {
        uVector.invertX();
    }

    public void boundY() {
        uVector.invertY();
    }

    public double getDiameter() {
        return this.getAppearance().getWidth();
    }


}
