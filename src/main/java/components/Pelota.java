package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Appearance;
import utils.XUpdater;
import utils.YUpdater;

import java.awt.*;


public class Pelota extends GameComponent<GameScene> {
    int directionX = 1;
    int directionY = 1;
    double velocity = 100;
    Dimension dimension;
    int diameter;

    public Pelota(Appearance appearance, double x, double y, Dimension dimension, int diameter){
        super(appearance,x,y);
        this.dimension = dimension;
        this.diameter = diameter;
    }

    @Override
    public void update(DeltaState deltaState) {
        this.updateX(deltaState);
        this.updateY(deltaState);
    }

    public void updateX(DeltaState delta){
        new XUpdater(this).update(delta);
    }

    public void updateY(DeltaState delta){
        new YUpdater(this).update(delta);
    }

    public double getVelocityFactor(DeltaState deltaState){
        return velocity * deltaState.getDelta();
    }

    public Dimension getDimension(){
        return dimension;
    }

    public int getDiameter(){
        return diameter;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

}
