package components;

import java.awt.Color;

import utils.XUpdater;
import utils.YUpdater;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Circle;


public class Pelota extends GameComponent<GameScene> {
    int directionX = 1;
    int directionY = 1;
    double velocity = 100;
	final int diameter = 50;

    public Pelota(GameScene scene, double x, double y) {
        super(x, y);
        
        this.setAppearance(new Circle(Color.blue, diameter));
        this.setScene(scene);
    }

    @Override
    public void update(DeltaState deltaState) {
        this.updateX(deltaState);
        this.updateY(deltaState);
        super.update(deltaState);
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
