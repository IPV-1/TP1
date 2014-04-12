package scenes;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Label;
import com.uqbar.vainilla.events.constants.Key;

public class EndScene extends GameScene {

	public EndScene(Game game, String message) {
		Font font = new Font("verdana", Font.BOLD, 24);
		Label label = new Label(font, Color.BLUE, message,
				"Presiona N para un juego nuevo");
		this.addComponent(new GameComponent<GameScene>(label, 10, 10) {
			@Override
			public void update(DeltaState deltaState) {
				if (deltaState.isKeyPressed(Key.N)) {
					this.getGame().setCurrentScene(
							new ArkanoidScene(this.getGame()));
				}
				super.update(deltaState);
			}
		});
	}

}
