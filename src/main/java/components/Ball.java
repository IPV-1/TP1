package components;

import java.awt.Color;

import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Circle;

import utils.MovingGameComponent;

public class Ball extends MovingGameComponent {
	
	public Ball(GameScene scene, Color color, int diameter, double xPos, double yPos, double xVec,
			double yVec, double speed) {
		super(new Circle(color, diameter), xPos, yPos, xVec, yVec, speed);
		this.setScene(scene);
	}

}
