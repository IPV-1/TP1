package components;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.ArkanoidScene;

public abstract class ArkanoidGameComponent extends GameComponent<ArkanoidScene> implements Collidable {
    public ArkanoidGameComponent(Appearance appearance, double x, double y) {
        super(appearance, x, y);
    }


    @Override
    public ArkanoidGameComponent asComponent(){
        return this;
    }

    @Override
    public void bounceBallY(Ball ball) {
        ball.getUVector().invertY();
    }

}
