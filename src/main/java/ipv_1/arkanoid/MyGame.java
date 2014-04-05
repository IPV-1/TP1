package ipv_1.arkanoid;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.Circle;
import components.Pelota;

import java.awt.*;

public class MyGame extends Game {

	private Dimension dimension;
	
	public static void main(String[] args) throws Exception {
		new DesktopGameLauncher(new MyGame()).launch();
	}

	@Override
	protected void initializeResources() {
		dimension = new Dimension(800, 600);
	}

	@Override
	protected void setUpScenes() {
		GameScene scene = new GameScene();
		final int diameter = 50;
        //TODO: We're passing diameter to Circle and to Pelota classes.
        // There must be a simplest solution.
        Appearance appearance = new Circle(Color.blue, diameter);
		scene.addComponent(new Pelota(appearance, 0, 290, dimension, diameter));
		this.setCurrentScene(scene);
	}

	@Override
	public Dimension getDisplaySize() {
		return dimension;
	}

	@Override
	public String getTitle() {
		return "MyGame";
	}


}
