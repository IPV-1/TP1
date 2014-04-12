package components;

import java.awt.Color;

import scenes.ArkanoidScene;
import utils.XUpdater;
import utils.YUpdater;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.Bounds;
import com.uqbar.vainilla.colissions.CollisionDetector;

public class Ball extends MovingGameComponent {
	
    public Ball(Color color, int diameter, double xPos, double yPos, UnitVector2D direction, double speed) {
        super(new Circle(color, diameter), xPos, yPos, direction.getX(), direction.getY(), speed);
    }

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        if(this.updateX(deltaState)) {
        	this.bounceX();
        }
        if(this.updateY(deltaState)) {
        	this.bounceY();
        }
        
        ((ArkanoidScene)this.getScene()).verifyBallCollides(this);
    }
    
	public void collide(GameComponent<?> component) {
		Bounds ballB = new Bounds(this);
		Bounds componentB = new Bounds(component);
		
		if(CollisionDetector.INSTANCE.isHorizontalCollision(ballB, componentB)){
			if(ballB.getTop() < componentB.getTop()) {
				this.setY(component.getY() - this.getHeight() - 1);
			} else {
				this.setY(component.getY() + component.getHeight() + 1);
			}
			bounceY();
		} else {
			if(ballB.getLeft() < componentB.getLeft()) {
				this.setX(component.getX() - this.getWidth() - 1);
			} else {
				this.setX(component.getX() + component.getWidth() + 1);
			}
			bounceX();
		}
	}

	public boolean updateX(DeltaState delta){
        return XUpdater.INSTANCE.update(this);
    }

    public boolean  updateY(DeltaState delta){
    	return YUpdater.INSTANCE.update(this);
    }

    public void bounceX() {
        uVector.invertX();
    }

    public void bounceY() {
        uVector.invertY();
    }

    public double getDiameter() {
        return this.getAppearance().getWidth();
    }

	public void placeOver(Platform platform) {
		this.setY(platform.getY() - this.getHeight() - 1);
	}

}
