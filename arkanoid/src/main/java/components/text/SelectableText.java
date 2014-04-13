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
    private boolean selected = false;

    public SelectableText(String text, double x, double y, boolean selected) {
        super(x, y);
        this.selected = selected;
        this.setAppearance(new Label(new Font("SansSerif", this.style, 50), Color.RED, text));
        if (this.selected) {
            this.select();
        }
    }

    public void update(DeltaState deltaState) {
        if (this.clicked(deltaState)) {
            this.getGame().setCurrentScene(this.getNewScene());
        }
    }

    public void select() {
        this.style = Font.BOLD;
        this.changeStyle(this.style);
    }

    public void unselect(){
        this.style = Font.PLAIN;
        this.changeStyle(this.style);
    }

    public boolean clicked(DeltaState deltaState){
        return deltaState.isKeyReleased(this.textKey()) && this.selected;
    }

    protected abstract Key textKey();

    protected void changeStyle(int style){
        this.style = style;
        Label label = (Label) this.getAppearance();
        Font font = label.getFont().deriveFont(style);
        label.setFont(font);
    }

    public abstract GameScene getNewScene();

}
