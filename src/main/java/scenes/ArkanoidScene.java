package scenes;

import com.uqbar.vainilla.GameScene;
import components.Ball;
import components.Pelota;

import java.awt.*;

public class ArkanoidScene extends GameScene {
	
	public ArkanoidScene() {
		super();

		this.addComponent(new Pelota(0, 290));
		this.addComponent(new Ball(Color.black, 50, 100, 390, 1, 1, 100));
	}
}
