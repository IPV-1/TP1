package components;

import java.awt.Color;

import scenes.ArkanoidScene;
import utils.XUpdater;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.events.constants.Key;

public class Platform extends MovingGameComponent {
	
	protected int maxSpeed = 250;

    public Platform(Color color, int width, int height, double xPos, double yPos) {

        super(new Rectangle(color, width, height), xPos, yPos, 1, 1, 0);
    }

	@Override
    public void update(DeltaState deltaState){
        this.anyKeyPressed(deltaState);
        super.update(deltaState);
        XUpdater.INSTANCE.update(this);
    }

    public void anyKeyPressed(DeltaState deltaState){
        if(deltaState.isKeyBeingHold(Key.LEFT)) {
        	this.getUVector().set(-1, 0);
        	this.setSpeed(this.getMaxSpeed());
        } else if(deltaState.isKeyBeingHold(Key.RIGHT)) {
        	this.getUVector().set(1, 0);
        	this.setSpeed(this.getMaxSpeed());
        } else {
        	this.setSpeed(0);
        }
    }
    
    @Override
    public void collide(GameComponent<?> component) {
    	((ArkanoidScene)this.getScene()).speedUp(10);
    }
    
	public int getMaxSpeed() {
		return maxSpeed;
	}
    
    
}
