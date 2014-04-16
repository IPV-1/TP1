package components.appearances;


import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.FilledArc;
import com.uqbar.vainilla.colissions.Circle;

import java.awt.*;

public class MultiFilledArc implements Appearance{
    private final double radius;
    private FilledArc lastArc1;
    private FilledArc lastArc2;
    private FilledArc lastArc3;


    public MultiFilledArc(double radius, Color color1, Color color2, Color color3) {
        this.radius = radius;
        lastArc1 = new FilledArc(color1, (int) radius, initialPosition(), 120);
        lastArc2 = new FilledArc(color2, (int) radius, middlePosition(), 120);
        lastArc3 = new FilledArc(color3, (int) radius, lastPosition(), 120);
    }

    @Override
    public double getWidth() {
        return this.radius * 2;
    }

    @Override
    public double getHeight() {
        return this.radius * 2;
    }

    @Override
    public <T extends Appearance> T copy() {
        return null;
    }

    @Override
    public void update(double delta) {
        Color auxColor = lastArc1.getColor();
        lastArc1.setColor(lastArc2.getColor());
        lastArc2.setColor(lastArc3.getColor());
        lastArc3.setColor(auxColor);
    }

    @Override
    public void render(GameComponent<?> component, Graphics2D graphics) {
        lastArc1.render(component, graphics);
        lastArc2.render(component, graphics);
        lastArc3.render(component, graphics);
    }


    private double initialPosition(){
        return 0;
    }
    private double middlePosition(){
        return 120;
    }
    private double lastPosition(){
        return 240;
    }
    private double end(){
        return 360;
    }

}
