package scenes.statics;


import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameScene;
import components.text.Level1Text;
import components.text.Level2Text;
import components.text.SelectableText;
import components.text.TextSelector;

import java.util.ArrayList;

public class StartScene extends GameScene {

    public StartScene (Game game) {
        super();
        this.setGame(game);
        ArrayList<SelectableText> selectableTexts = new ArrayList<SelectableText>();
        selectableTexts.add(new Level1Text("Level 1", 50, 50, true));
        selectableTexts.add(new Level2Text("Level 2", 50, 200, false));

        this.addComponent(new TextSelector(selectableTexts));
        this.addComponents(selectableTexts);
    }

}
