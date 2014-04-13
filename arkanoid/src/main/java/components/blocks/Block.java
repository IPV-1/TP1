package components.blocks;

import com.uqbar.vainilla.appearances.Rectangle;
import components.ArkanoidGameComponent;
import components.Ball;

import java.awt.*;

public class Block extends ArkanoidGameComponent {
	
	public static final int WIDTH = 50;
	public static final int HEIGHT = 20;

	public Block(Color color, double x, double y){
		super(new Rectangle(color, Block.WIDTH, Block.HEIGHT), x, y);
	}
	

	public void collidedBy(Ball ball) {
		this.getScene().addScore(100);
		this.explode();
	}
	
	// Could throw a gift
	public void explode() {
        this.getScene().removeCollidable(this);
		this.destroy();
	}

}
