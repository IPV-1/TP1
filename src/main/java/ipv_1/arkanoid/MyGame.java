package ipv_1.arkanoid;

import java.awt.Color;
import java.awt.Dimension;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Circle;

public class MyGame extends Game {

	private Dimension dimension;
	
	public static void main(String[] args) throws Exception {
		new DesktopGameLauncher(new MyGame()).launch();
	}

	@Override
	protected void initializeResources() {
		dimension = new Dimension(800, 600);

	}

	@Override
	protected void setUpScenes() {
		GameScene scene = new GameScene();
		final int diameter = 50;
		scene.addComponent(new GameComponent<GameScene>(new Circle(Color.blue, diameter), 0, 290) {
			int directionX = 1;
			int directionY = 1;
			double velocity = 100;
			
			@Override
			public void update(DeltaState deltaState) {
				this.setX(this.getX() + directionX*velocity*deltaState.getDelta());
				if(this.getX() <= 0 ) {
					this.setX(0);
					directionX = -directionX;
				} else if(this.getX() + diameter >=dimension.width) {
					this.setX(dimension.width - diameter);
					directionX = -directionX;					
				}
				
				this.setY(this.getY() + directionY*velocity*deltaState.getDelta());
				if(this.getY() <= 0 ) {
					this.setY(0);
					directionY = -directionY;
				} else if(this.getY() + diameter >=dimension.height) {
					this.setX(dimension.height - diameter);
					directionY = -directionY;					
				}
			}
		});
		this.setCurrentScene(scene);
	}

	@Override
	public Dimension getDisplaySize() {
		return dimension;
	}

	@Override
	public String getTitle() {
		return "MyGame";
	}


}
