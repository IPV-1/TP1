package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.events.constants.Key;
import utils.MovingGameComponent;

import java.awt.*;

public class Platform extends MovingGameComponent {
	
	protected int maxSpeed = 200;

    public Platform(Color color, int width, int height, double xPos, double yPos) {

        super(new Rectangle(color, width, height), xPos, yPos, 1, 1, 0);
    }

    @Override
    public void update(DeltaState deltaState){
        this.anyKeyPressed(deltaState);

        super.update(deltaState);

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

	public int getMaxSpeed() {
		return maxSpeed;
	}
    
    
}
