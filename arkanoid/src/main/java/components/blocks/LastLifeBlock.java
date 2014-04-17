package components.blocks;

import components.Ball;
import components.awards.BallsAward;

import java.awt.*;


public class LastLifeBlock extends BlockState {

    protected int getScore() {
        return 300;
    }

    @Override
    public void collidedBy(Ball ball, MultiLifeBlock block) {
        block.getScene().addScore(this.getScore());
        block.getScene().addComponent(new BallsAward(block.getX(), block.getY(), block.getGame().getDisplayHeight()));
        block.explode();
    }

    protected Color getColor() {
        return Color.YELLOW;
    }

}
