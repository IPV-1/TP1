package scenes;

import com.uqbar.vainilla.Game;
import components.Collidable;
import components.blocks.BlockFactory;
import components.blocks.MultiLifeBlock;
import scenes.statics.WinScene;
import utils.YUpdater;

import java.util.ArrayList;

public class Level2 extends BasicArkanoidScene {


    public Level2(Game game) {
        super(game);
    }

    public void addBlocks() {
        ArrayList<MultiLifeBlock> blocks = BlockFactory.multiLifeBlocks(this.getGame().getDisplayWidth(), YUpdater.UPPER_LIMIT);
        this.addComponents(blocks);
        for(Collidable c : blocks){
            this.addCollidable(c);
        }
    }

    public void win() {
        this.getGame().setCurrentScene(new WinScene(this.getGame()));
    }


}
