package components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.events.constants.Key;
import utils.MovingGameComponent;
import utils.UnitVector2D;

import java.awt.*;

public class Platform extends MovingGameComponent {

    public Platform(Color color, int width, int height, double xPos, double yPos) {

        super(new Rectangle(color, width, height), xPos, yPos, 1, 1, 0);
    }

    @Override
    public void update(DeltaState deltaState){
        this.anyKeyPressed(deltaState);

        super.update(deltaState);

    }

    public void anyKeyPressed(DeltaState deltaState){
        if(deltaState.isKeyBeingHold(Key.LEFT)) {
            uVector = new UnitVector2D(-1, 0);
            speed = 100;
        } else if(deltaState.isKeyBeingHold(Key.RIGHT)) {

            uVector = new UnitVector2D(1, 0);
            speed = 100;
        } else {
            speed = 0;
        }
    }
}
