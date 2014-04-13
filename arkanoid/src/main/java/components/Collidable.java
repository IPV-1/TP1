package components;

import com.uqbar.vainilla.colissions.Rectangle;

public interface Collidable {
    public void collidedBy(Ball ball);

    //TODO: Remove this
    Rectangle getRect();
}
