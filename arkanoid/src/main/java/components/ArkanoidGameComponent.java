package components;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.BasicArkanoidScene;

public abstract class ArkanoidGameComponent extends GameComponent<BasicArkanoidScene> implements Collidable {
    public ArkanoidGameComponent(Appearance appearance, double x, double y) {
        super(appearance, x, y);
    }

    public ArkanoidGameComponent(double x, double y) {
        super(x,y);
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
