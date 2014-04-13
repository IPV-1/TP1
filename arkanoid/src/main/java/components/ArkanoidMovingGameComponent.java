package components;


import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.ArkanoidScene;

public abstract class ArkanoidMovingGameComponent extends MovingGameComponent<ArkanoidScene> implements Collidable {
    public ArkanoidMovingGameComponent(Appearance appearance, double xPos, double yPos, int i, int i1, int i2) {
        super(appearance, xPos, yPos, i, i1, i2);
    }

    public ArkanoidMovingGameComponent(Appearance appearance, double xPos, double yPos, double x, double y, double speed) {
        super(appearance, xPos, yPos, x, y, speed);
    }
}
