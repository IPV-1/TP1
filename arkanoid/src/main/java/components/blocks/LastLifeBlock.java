package components.blocks;

import components.Ball;

import java.awt.*;


public class LastLifeBlock extends BlockState {

    protected int getScore(){
        return 300;
    }

    @Override
    public void collidedBy(Ball ball, MultiLifeBlock block) {
        block.getScene().addScore(this.getScore());
        block.explode();
    }

    protected Color getColor(){
        return Color.YELLOW;
    }

}
