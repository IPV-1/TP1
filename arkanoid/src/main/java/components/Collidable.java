package components;

import com.uqbar.vainilla.GameComponent;

public interface Collidable {
    public void collide(GameComponent<?> component);
}
