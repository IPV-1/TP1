package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Appearance;

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
        double velocityFactor = this.getVelocityFactor(deltaState);
        this.updateX(velocityFactor);
        this.updateY(velocityFactor);
    }

    public void updateX(double velocityFactor){
        this.setX(this.getX() + directionX * velocityFactor);
        if (this.getX() <= 0) {
            this.setX(0);
            directionX = -directionX;
        } else if (this.getX() + diameter >= dimension.width) {
            this.setX(dimension.width - diameter);
            directionX = -directionX;
        }
    }

    public void updateY(double velocityFactor){
        this.setY(this.getY() + directionY * velocityFactor);
        if (this.getY() <= 0) {
            this.setY(0);
            directionY = -directionY;
        } else if (this.getY() + diameter >= dimension.height) {
            this.setY(dimension.height - diameter);
            directionY = -directionY;
        }
    }

    public double getVelocityFactor(DeltaState deltaState){
        return velocity * deltaState.getDelta();
    }

}
