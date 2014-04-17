package components.awards;


import com.uqbar.vainilla.UnitVector2D;
import components.Ball;

import java.awt.*;

public class BallsAward extends Award {
    public BallsAward(double xPos, double yPos, int limit) {
        super(xPos, yPos, limit);
    }

    @Override
    public void giveAware() {
        this.getScene().addBall(new Ball(Color.RED, 100, 390, new UnitVector2D(1, -1), 200));
    }
}
