import java.awt.*;

public class Paddle extends GameObject{
    private int xVelocity;

    public Paddle(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        super(gl, xp, yp, xs, ys, c);
        xVelocity = 0;
    }

    public void setVelocity(int xv) {
        this.xVelocity = xv;
    }
}
