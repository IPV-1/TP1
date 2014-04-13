package components;

import com.uqbar.vainilla.GameComponent;

public interface Collidable {
    public void collidedBy(Ball ball);

    public GameComponent asComponent();

}
