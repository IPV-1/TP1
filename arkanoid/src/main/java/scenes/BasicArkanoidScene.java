package scenes;

import img.Resource;
import ipv_1.arkanoid.MyGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import scenes.statics.LoseScene;

import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.Ball;
import components.Collidable;
import components.Platform;
import components.ScoreBoard;
import components.blocks.Block;

public abstract class BasicArkanoidScene extends GameScene {
    private Platform platform = new Platform(Color.blue, 10, 20, 580);
    private Ball ball = new Ball(Color.black, 100, 390, new UnitVector2D(1, -1), 200);
    private List<Block> blocks = new ArrayList<Block>();
    private List<Collidable> collidableList = new ArrayList<Collidable>();
	
    private String backgroundPath = "board.png";

    public BasicArkanoidScene(Game game) {
        super();
        this.setGame(game);
        
        this.addComponent(getBackground());
        
        this.addComponent(this.getScoreBoard());
        this.addBlocks();
        this.addComponent(this.getPlatform());
        this.addCollidable(this.getPlatform());
        this.getPlatform().center();
        this.addComponent(this.getBall());
        this.getBall().center();
        this.getBall().placeOver(this.getPlatform());
    }

    private GameComponent<?> getBackground() {
        return new GameComponent<GameScene>(Resource.getSprite(backgroundPath), 0, 0);
	}

	public void verifyBallCollides(Ball ball) {
        //TODO: refactor this.
        for (Collidable collidable : this.getCollidables()) {
            GameComponent<?> component = collidable.asComponent();
            if(CollisionDetector.INSTANCE.collidesCircleAgainstRect(ball.getCirc(), component.getRect())) {

                // Notify collides ball with component
                ball.collide(collidable);
                collidable.collidedBy(ball);
            }
        }
        if(this.getBlocks().isEmpty()) {
            this.win();
        }
    }

    public void lose() {
        //TODO: player should lost a life
    	this.getScoreBoard().reset();
        this.getGame().setCurrentScene(new LoseScene(this.getGame()));
    }

    public abstract void win();

    public abstract void addBlocks();

    public void addBlocks(ArrayList<Block> blocks){
        this.addComponents(blocks);
        this.getBlocks().addAll(blocks);
    }

    public void addScore(int value) {
        this.getScoreBoard().add(value);
    }

    public void speedUp(int value) {
        this.getBall().speedUp(value);
    }

    public ScoreBoard getScoreBoard() {
        return ((MyGame)this.getGame()).getScoreBoard();
    }

    public Platform getPlatform() {
        return platform;
    }

    public Ball getBall(){
        return ball;
    }

    public void addCollidable(Collidable collidable){
        collidableList.add(collidable);
    }

    public ArrayList<Collidable> getCollidables(){
        return new ArrayList<Collidable>(this.collidableList);
    }

    public void removeCollidable(Collidable collidable) {
        collidableList.remove(collidable);
    }

	public List<Block> getBlocks() {
		return blocks;
	}

	public void removeBlock(Block block) {
		blocks.remove(block);
	}

}
