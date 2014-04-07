package scenes;

import com.uqbar.vainilla.GameScene;
import components.Pelota;

public class ArkanoidScene extends GameScene {
	
	public ArkanoidScene() {
		super();

		this.addComponent(new Pelota(this, 0, 290));
	}
}
