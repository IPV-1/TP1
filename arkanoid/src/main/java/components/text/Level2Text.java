package components.text;


import com.uqbar.vainilla.GameScene;
import scenes.Level2;

public class Level2Text extends StartGameText{
    public Level2Text(String text, double x, double y, boolean selected) {
        super(text, x, y, selected);
    }

    public GameScene getNewScene(){
        return new Level2(this.getGame());
    }
}
