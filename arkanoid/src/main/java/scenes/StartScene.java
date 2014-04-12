package scenes;


import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameScene;
import components.text.SelectableText;
import components.text.StartGameText;

public class StartScene extends GameScene {

    public StartScene (Game game) {
        super();
        this.setGame(game);
        SelectableText text = new StartGameText("Press enter to start", 50, 50, true);
        this.addComponent(text);
    }

}
