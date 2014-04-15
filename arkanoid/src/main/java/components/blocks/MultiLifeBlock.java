package components.blocks;

import com.uqbar.vainilla.appearances.Rectangle;
import components.Ball;

public class MultiLifeBlock extends Block {

    private BlockState state = new FirstLifeBlock();

    public MultiLifeBlock(double x, double y) {
        super(x, y);
    }

    public void collidedBy(Ball ball) {
        getState().collidedBy(ball, this);
    }

    public Rectangle getAppearance(){
        return this.getState().getAppearance(this);
    }

    public BlockState getState(){
        return this.state;
    }

    public void setState(BlockState blockState){
        this.state = blockState;
    }


}
