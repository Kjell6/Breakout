import java.awt.*;

public class Brick extends GameObject{
    private boolean destroyed;

    public Brick(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        super(gl, xp, yp, xs, ys, c);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        this.destroyed = true;
    }

    public void setIntact() {
        this.destroyed = false;
    }
}
