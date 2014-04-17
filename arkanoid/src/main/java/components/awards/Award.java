package components.awards;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.appearances.MultiFilledArc;
import scenes.BasicArkanoidScene;

import java.awt.*;

public abstract class Award extends MovingGameComponent<BasicArkanoidScene>{

    int displayHeight;

    public Award(double xPos, double yPos, int limit){
        super(new MultiFilledArc(20, Color.RED,Color.YELLOW, Color.BLUE ),xPos, yPos, 0, 1, 100);
        displayHeight = limit;
    }

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        if(getY() > displayHeight){
            this.destroy();
        }else if (collidePlatform()){
            this.destroy();
            this.giveAware();
        }
    }

    public boolean collidePlatform(){
        return CollisionDetector.INSTANCE.collidesCircleAgainstRect(getCirc(), getScene().getPlatform().getRect());
    }

    public abstract void giveAware();


}
