package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.events.constants.Key;
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
        if(getScene().getBalls().isEmpty())
            getScene().lose();
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
    public void collidedBy(Ball ball) {
    	this.getScene().speedUp(10);
    }

    @Override
    public void bounceBallY(Ball ball) {
        GameComponent<?> component = this.asComponent();
        final double LIMIT = 0.65;
        double dif = (ball.getX() - component.getX()) / Platform.WIDTH * LIMIT;
        ball.getUVector().setPI(dif - 1 + (1 - LIMIT) / 2);
    }

    public int getMaxSpeed() {
		return maxSpeed;
	}


}
