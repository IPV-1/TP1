package components;


import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.BasicArkanoidScene;

public abstract class ArkanoidMovingGameComponent extends MovingGameComponent<BasicArkanoidScene> implements Collidable {
    public ArkanoidMovingGameComponent(Appearance appearance, double xPos, double yPos, int i, int i1, int i2) {
        super(appearance, xPos, yPos, i, i1, i2);
    }

    @Override
    public ArkanoidMovingGameComponent asComponent(){
        return this;
    }

    @Override
    public void bounceBallY(Ball ball) {
        ball.getUVector().invertY();
    }
}
