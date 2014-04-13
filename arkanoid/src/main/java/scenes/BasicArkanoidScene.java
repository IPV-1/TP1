package scenes;

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
import scenes.statics.LoseScene;

import java.awt.*;
import java.util.ArrayList;

public abstract class BasicArkanoidScene extends GameScene {
    private ScoreBoard scoreBoard = new ScoreBoard(10, 5, Color.black);
    private Platform platform = new Platform(Color.blue, 10, 20, 580);
    private Ball ball = new Ball(Color.black, 100, 390, new UnitVector2D(1, -1), 200);
    private ArrayList<Collidable> collidableList = new ArrayList<Collidable>();

    public BasicArkanoidScene(Game game) {
        super();
        this.setGame(game);
        this.addComponent(this.getScoreBoard());
        this.addBlocks();
        this.addComponent(this.getPlatform());
        this.addCollidable(this.getPlatform());
        this.getPlatform().center();
        this.addComponent(this.getBall());
        this.getBall().center();
        this.getBall().placeOver(this.getPlatform());

    }

    public void verifyBallCollides(Ball ball) {
        //TODO: refactor this.
        for (Collidable collidable : this.getCollidables()) {
            GameComponent component = collidable.asComponent();
            if(CollisionDetector.INSTANCE.collidesCircleAgainstRect(ball.getCirc(), component.getRect())) {

                // Notify collides ball with component
                ball.collide(collidable);
                collidable.collidedBy(ball);
            }
        }
        if(this.getComponentCount() == 3) {
            this.win();
        }
    }

    public void lose() {
        //TODO: player should lost a life
        this.getGame().setCurrentScene(new LoseScene(this.getGame()));
    }

    public abstract void win();

    public abstract void addBlocks();

    public void addBlocks(ArrayList<Block> blocks){
        this.addComponents(blocks);
    }

    public void addScore(int value) {
        this.getScoreBoard().add(value);
    }

    public void speedUp(int value) {
        this.getBall().speedUp(value);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
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
}
