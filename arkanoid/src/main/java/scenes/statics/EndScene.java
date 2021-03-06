package scenes.statics;

import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Label;
import components.text.NewGameText;

import java.awt.*;

public class EndScene extends GameScene {

    public EndScene(Game game, String message) {
        Font font = new Font("verdana", Font.BOLD, 24);
        Label label = new Label(font, Color.BLUE, message,
                "Presiona N para un juego nuevo");
        this.addComponent(new NewGameText(label, 10, 10, true));
    }

}
