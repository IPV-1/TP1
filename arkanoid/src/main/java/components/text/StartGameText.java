package components.text;

import com.uqbar.vainilla.GameScene;
import scenes.ArkanoidScene;

public class StartGameText extends SelectableText{


    public StartGameText(String text, double x, double y, boolean selected) {
        super(text, x, y, selected);
    }

    public GameScene getNewScene(){
        return new ArkanoidScene(this.getGame());
    }

}
