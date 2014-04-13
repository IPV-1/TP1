package scenes;

import com.uqbar.vainilla.Game;
import components.blocks.BlockFactory;
import utils.YUpdater;

public class ArkanoidScene extends BasicArkanoidScene {


    public ArkanoidScene(Game game) {
        super(game);
    }

    public void addBlocks() {
        BlockFactory.addBlocks(this, YUpdater.UPPER_LIMIT);
    }

    public void win() {
        this.getGame().setCurrentScene(new WinScene(this.getGame()));
    }


}
