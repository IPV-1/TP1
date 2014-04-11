package components;

import java.awt.Color;

import scenes.ArkanoidScene;
import utils.MovingGameComponent;
import utils.XUpdater;
import utils.YUpdater;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.Bounds;

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
        
        ((ArkanoidScene)this.getScene()).verifyBallCollides(this);
    }
    
	public void collide(GameComponent<?> component) {
		Bounds ballB = new Bounds(this.getX(), this.getY(), this.getAppearance().getWidth(), this.getAppearance().getHeight());
		Bounds componentB = new Bounds(component.getX(), component.getY(), component.getAppearance().getWidth(), component.getAppearance().getHeight());
		
		if(isHorizontalCollision(ballB, componentB)){
			if(ballB.getTop() < componentB.getTop()) {
				this.setY(component.getY() - this.getAppearance().getHeight() - 1);
			} else {
				this.setY(component.getY() + component.getAppearance().getHeight() + 1);
			}
			boundY();
		} else {
			if(ballB.getLeft() < componentB.getLeft()) {
				this.setX(component.getX() - this.getAppearance().getWidth() - 1);
			} else {
				this.setX(component.getX() + component.getAppearance().getWidth() + 1);
			}
			boundX();
		}
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
	
	// Move to collision engine
	public boolean isHorizontalCollision(Bounds r1, Bounds r2) {		
		double tamX = r2.getRight() - r1.getLeft();
		double tamY = r2.getBottom() - r1.getTop();
		
		if(r1.getLeft() <= r2.getLeft() && r2.getLeft() < r1.getRight()) {
			tamX = r1.getRight() - r2.getLeft(); 
		}
		
		if(r1.getTop() <= r2.getTop() && r2.getTop() < r1.getBottom()) {
			tamY = r1.getBottom() - r2.getTop();
		}
		
		return tamY < tamX;
	}
}
