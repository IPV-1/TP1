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
import com.uqbar.vainilla.colissions.CollisionDetector;

public class Ball extends MovingGameComponent {
	
	private XUpdater updateX;
	private YUpdater updateY;

    public Ball(Color color, int diameter, double xPos, double yPos, double xVec,
                double yVec, double speed) {
        super(new Circle(color, diameter), xPos, yPos, xVec, yVec, speed);
        this.updateX = new XUpdater(this);
        this.updateY = new YUpdater(this);
    }

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        this.updateX(deltaState);
        this.updateY(deltaState);
        
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
			boundY();
		} else {
			if(ballB.getLeft() < componentB.getLeft()) {
				this.setX(component.getX() - this.getWidth() - 1);
			} else {
				this.setX(component.getX() + component.getWidth() + 1);
			}
			boundX();
		}
	}

	public void updateX(DeltaState delta){
        updateX.update(delta);
    }

    public void updateY(DeltaState delta){
        updateY.update(delta);
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
