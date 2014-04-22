package scenes;

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
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private List<Block> blocks = new ArrayList<Block>();
    private List<Collidable> collidableList = new ArrayList<Collidable>();
	
    private String backgroundPath = "board.png";

    public BasicArkanoidScene(Game game) {
        super();
        this.setGame(game);
        
        this.addComponent(getBackground());
        
        this.addComponent(this.getScoreBoard());
        this.addLivesBoard();
        
        this.addBlocks();
        this.addComponent(this.getPlatform());
        this.addCollidable(this.getPlatform());
        this.getPlatform().center();
        addBall();
        centerBalls();
    }

	private void addLivesBoard() {
		this.addComponent(this.getLivesBoard());
		this.addComponent(this.getLiveImg());
	}

	private GameComponent<?> getLiveImg() {
		GameComponent<GameScene> liveImg = new GameComponent<GameScene>(Resource.getSprite("live.png"), 0, 0);
		
		liveImg.setX(this.getLivesBoard().getX() - liveImg.getWidth() - 5);
		liveImg.verticalCenterRespect(this.getLivesBoard());
		liveImg.setY(liveImg.getY() + 5);
		
		return liveImg;
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
    	this.getLivesBoard().die();
    	
    	if(this.getLivesBoard().lose()) {
	    	this.getScoreBoard().reset();
	    	this.getLivesBoard().reset();
	        this.getGame().setCurrentScene(new LoseScene(this.getGame()));
    	} else {
    		this.getBall().reset();
    	}
    }
    
    public void resetBallPosition() {
    	this.getBall().horizontalCenterRespect(this.getPlatform());
        this.getBall().placeOver(this.getPlatform());
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
        for(Ball ball : getBalls())
            ball.speedUp(value);
    }

    public ScoreBoard getScoreBoard() {
        return ((MyGame)this.getGame()).getScoreBoard();
    }

    public Platform getPlatform() {
        return platform;
    }

    public ArrayList<Ball> getBalls(){
        return balls;
    }

    public Ball getBall(){
        if(balls.isEmpty()){
            addBall();
        }
        return balls.get(0);
    }

    public void addBall(){
        addBall(new Ball(Color.BLUE, 100, 390, new UnitVector2D(1, -1), 200));
    }
    public void addBall(Ball ball){
        addComponent(ball);
        getBalls().add(ball);
    }
    public void removeBall(Ball ball){
        getBalls().remove(ball);
    }

    public void centerBalls(){
        for(Ball ball : getBalls()){
            ball.center();
            ball.placeOver(this.getPlatform());
        }

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
	
	public LivesBoard getLivesBoard() {
		return ((MyGame)this.getGame()).getLivesBoard();
	}

}
