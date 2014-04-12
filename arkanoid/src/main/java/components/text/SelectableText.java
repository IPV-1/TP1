package components.text;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Label;
import com.uqbar.vainilla.events.constants.Key;
import scenes.ArkanoidScene;

import java.awt.*;


public abstract class SelectableText extends GameComponent<ArkanoidScene> {
    public int style = Font.PLAIN;

    public SelectableText(String text, double x, double y, boolean selected) {
        super(x, y);
        if (selected) {
            this.style = Font.BOLD;
        } else {
            this.style = Font.PLAIN;
        }
        this.setAppearance(new Label(new Font("SansSerif", this.style, 50), Color.RED, text));
    }

    public void update(DeltaState deltaState) {
        if (deltaState.isKeyReleased(Key.ENTER)) {
            this.getGame().setCurrentScene(this.getNewScene());
        }
    }

    public abstract GameScene getNewScene();

}
