package components.blocks;

import components.Ball;

import java.awt.*;

public class FirstLifeBlock extends BlockState{

    @Override
    public void collidedBy(Ball ball, MultiLifeBlock block) {
        this.addScore(block);
        block.setState(new MediumLifeBlock());
    }

    protected int getScore(){
        return 100;
    }

    protected Color getColor(){
        return Color.RED;
    }

}
