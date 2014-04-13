package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.events.constants.Key;
import scenes.ArkanoidScene;
import utils.XUpdater;

import java.awt.*;

public class Platform extends ArkanoidMovingGameComponent {

	protected int maxSpeed = 250;

	public static final int WIDTH = 100;

    public Platform(Color color, int height, double xPos, double yPos) {

        super(new Rectangle(color, WIDTH, height), xPos, yPos, 1, 1, 0);
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
    public void collideBy(Ball ball) {
    	((ArkanoidScene)this.getScene()).speedUp(10);
    }

	public int getMaxSpeed() {
		return maxSpeed;
	}


}
