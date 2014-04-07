package scenes;

import java.awt.Color;

import com.uqbar.vainilla.GameScene;

import components.Ball;
import components.Pelota;

public class ArkanoidScene extends GameScene {
	
	public ArkanoidScene() {
		super();

		this.addComponent(new Pelota(this, 0, 290));
		this.addComponent(new Ball(this, Color.black, 50, 100, 390, 1, 1, 100));
	}
}
