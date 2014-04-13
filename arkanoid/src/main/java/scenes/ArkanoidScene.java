package scenes;

import com.uqbar.vainilla.Game;
import components.blocks.BlockFactory;
import scenes.statics.WinScene;
import utils.YUpdater;

public class ArkanoidScene extends BasicArkanoidScene {


    public ArkanoidScene(Game game) {
        super(game);
    }

    public void addBlocks() {
        this.addBlocks(BlockFactory.blocks(this.getGame().getDisplayWidth(), YUpdater.UPPER_LIMIT));
    }

    public void win() {
        this.getGame().setCurrentScene(new WinScene(this.getGame()));
    }


}
