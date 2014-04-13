package ipv_1.arkanoid;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import scenes.StartScene;

import java.awt.*;

public class MyGame extends Game {

	private Dimension dimension;
	
	@Override
	protected void initializeResources() {
		dimension = new Dimension(800, 600);
	}

	@Override
	protected void setUpScenes() {
		this.setCurrentScene(new StartScene(this));
	}

	@Override
	public Dimension getDisplaySize() {
		return dimension;
	}

	@Override
	public String getTitle() {
		return "Arkanoid";
	}

	public static void main(String[] args) throws Exception {
		new DesktopGameLauncher(new MyGame()).launch();
	}

}
