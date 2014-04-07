package components;

import com.uqbar.vainilla.appearances.Circle;
import utils.MovingGameComponent;

import java.awt.*;

public class Ball extends MovingGameComponent {
	
	public Ball( Color color, int diameter, double xPos, double yPos, double xVec,
			double yVec, double speed) {
		super(new Circle(color, diameter), xPos, yPos, xVec, yVec, speed);
	}

}
