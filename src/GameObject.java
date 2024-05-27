import java.awt.*;

public class GameObject {
    private java.awt.Color color;
    protected int xPosition;
    protected int yPosition;
    protected int xSize;
    protected int ySize;
    protected GameLogic gameLog;

    public GameObject(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        this.gameLog = gl;
        this.xPosition = xp;
        this.yPosition = yp;
        this.xSize = xs;
        this.ySize = ys;
        this.color = c;
    }

    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public int getX() {
        return this.xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public int getXSize() {
        return this.xSize;
    }

    public int getYSize() {
        return this.ySize;
    }

    public java.awt.Rectangle getHitBox() {
        Rectangle rec = new Rectangle(xPosition, yPosition, xSize, ySize);
        return rec;
    }
}
