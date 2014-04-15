package scenes;

import com.uqbar.vainilla.Game;
import components.Collidable;
import components.blocks.Block;
import components.blocks.BlockFactory;
import utils.YUpdater;

import java.util.ArrayList;

public class ArkanoidScene extends BasicArkanoidScene {


    public ArkanoidScene(Game game) {
        super(game);
    }

    public void addBlocks() {
        ArrayList<Block> blocks = BlockFactory.blocks(this.getGame().getDisplayWidth(), YUpdater.UPPER_LIMIT);
        this.addBlocks(blocks);
        for(Collidable c : blocks){
            this.addCollidable(c);
        }
    }

    public void win() {
        this.getGame().setCurrentScene(new Level2(this.getGame()));
    }


}
