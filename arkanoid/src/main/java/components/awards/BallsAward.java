package components.awards;


import com.uqbar.vainilla.UnitVector2D;
import components.Ball;

import java.awt.*;

import static utils.Utils.randInt;

public class BallsAward extends Award {
    public BallsAward(double xPos, double yPos, int limit) {
        super(xPos, yPos, limit);
    }

    @Override
    public void giveAware() {
        int x = randInt(100, 700);
        int y = randInt(400, 500);
        this.getScene().addBall(new Ball(Color.RED, x, y, new UnitVector2D(1, -1)));
    }
}
