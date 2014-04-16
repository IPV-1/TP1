package components.blocks;

import components.Ball;

import java.awt.*;

public class MediumLifeBlock extends BlockState{

    @Override
    public void collidedBy(Ball ball, MultiLifeBlock block) {
        this.addScore(block);
        block.setState(new LastLifeBlock());
    }

    protected int getScore(){
        return 200;
    }

    protected Color getColor(){
        return Color.BLUE;
    }

}
