package components.blocks;


import com.uqbar.vainilla.appearances.Rectangle;
import components.Ball;

import java.awt.*;


public abstract class BlockState {
    private Rectangle appearance;

    public Rectangle getAppearance(MultiLifeBlock block) {
        if (this.appearance == null) {
            this.appearance = new Rectangle(this.getColor(), MultiLifeBlock.WIDTH, MultiLifeBlock.HEIGHT);
        }
        return this.appearance;
    }

    public void addScore(MultiLifeBlock block){
        block.getScene().addScore(this.getScore());
    }

    protected abstract int getScore();

    public abstract void collidedBy(Ball ball, MultiLifeBlock block);

    protected abstract Color getColor();
}
