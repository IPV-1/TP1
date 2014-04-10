package scenes;

import java.awt.Color;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.colissions.CollisionDetector;

import components.Ball;
import components.Platform;

public class ArkanoidScene extends GameScene {
	
	public ArkanoidScene() {
		super();
		this.addComponent(new Ball(Color.black, 50, 100, 390, 1, 1, 300));
        this.addComponent(new Platform(Color.blue, 50, 50, 20, 480));
	}
	
	public void verifyBallCollides(Ball ball) {
		for (GameComponent<?> component : this.getComponents()) {
			
			if(component != ball &&
				CollisionDetector.INSTANCE.collidesCircleAgainstRect(
					ball.getX(), ball.getY(), ball.getDiameter() / 2,
					component.getX(), component.getY(), component.getAppearance().getWidth(), component.getAppearance().getHeight()
				)) {
				
				
				// Notify collides ball with component
				ball.collides(component);
			}
		}
	}
}
