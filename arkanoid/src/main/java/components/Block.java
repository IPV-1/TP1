package components;

import java.awt.Color;

import scenes.ArkanoidScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;

public class Block extends GameComponent<ArkanoidScene> {
	
	public static final int WIDTH = 50;
	public static final int HEIGHT = 20;

	public Block(Color color, double x, double y){
		super(new Rectangle(color, Block.WIDTH, Block.HEIGHT), x, y);
	}
	
	@Override
	public void collide(GameComponent<?> component) {
		((ArkanoidScene)this.getScene()).addScore(100);
		this.explode();
	}
	
	// Could throw a gift
	public void explode() {
		this.destroy();
	}

}
