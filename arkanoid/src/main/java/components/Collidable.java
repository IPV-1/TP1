package components;

import com.uqbar.vainilla.colissions.Rectangle;

public interface Collidable {
    public void collideBy(Ball ball);

    //TODO: Remove this
    Rectangle getRect();
}
