package ipv_1.arkanoid;


import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

import components.boards.LivesBoard;
import components.boards.ScoreBoard;


import scenes.statics.StartScene;

import java.awt.*;

public class MyGame extends Game {

	private ScoreBoard scoreBoard = new ScoreBoard(15, 3, Color.white);
    private LivesBoard livesBoard = new LivesBoard(615, 3, Color.white);
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

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

	public LivesBoard getLivesBoard() {
		return livesBoard;
	}

}
