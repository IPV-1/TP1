package components.blocks;

import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.appearances.Sprite;

import components.ArkanoidGameComponent;
import components.Ball;

import img.Resource;

import java.awt.*;

public class Block extends ArkanoidGameComponent {

	public static final int WIDTH = 50;
	public static final int HEIGHT = 25;
	
	public static final Sprite RED = Resource.getSprite("block_red.png");
	public static final Sprite BLUE = Resource.getSprite("block_blue.png");
	public static final Sprite GREEN = Resource.getSprite("block_green.png");
	public static final Sprite YELLOW = Resource.getSprite("block_yellow.png");

	public Block(Color color, double x, double y){
		super(new Rectangle(color, Block.WIDTH, Block.HEIGHT), x, y);
	}
	
	public Block(Sprite sprite, double x, double y){
		super(sprite, x, y);
	}

    public Block(double x, double y){
        super(x, y);
    }

	public void collidedBy(Ball ball) {
		this.getScene().addScore(100);
		this.explode();
	}

	// Could throw a gift
	public void explode() {
		this.getScene().removeBlock(this);
        this.getScene().removeCollidable(this);
		this.destroy();
	}

}
