package components.text;

import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.events.constants.Key;
import scenes.ArkanoidScene;

public class StartGameText extends SelectableText{


    public StartGameText(String text, double x, double y, boolean selected) {
        super(text, x, y, selected);
    }

    public GameScene getNewScene(){
        return new ArkanoidScene(this.getGame());
    }

    protected Key textKey(){
        return Key.ENTER;
    }

}
