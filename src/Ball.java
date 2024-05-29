import java.awt.*;

public class Ball extends GameObject{
    private int xVelocity;
    private int yVelocity;

    public Ball(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        super(gl, xp, yp, xs, ys, c);
        xVelocity = 0;
        yVelocity = 0;
    }

    public void setVelocity(int x, int y) {
        this.xVelocity = x;
        this.yVelocity = y;
    }

    public int getXVelocity() {
        return this.xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }
}
