package components;

import java.awt.Color;
import java.awt.Font;

import scenes.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

public class ScoreBoard extends GameComponent<ArkanoidScene> {

	private int value;
	
	public ScoreBoard(double x, double y, Color color) {		
		super(new Label(new Font("verdana",  Font.BOLD, 36), color, "0"), x, y);
		this.value = 0;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		((Label)this.getAppearance()).setText("Score: "+ Integer.toString(this.getValue())); 
		super.update(deltaState);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void add(int value) {
		this.setValue(this.getValue() + value);
	}

}
