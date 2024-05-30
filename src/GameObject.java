import java.awt.*;

/**
 * Basisklasse für Spielobjekte.
 *
 * @author Kjell Behrends
 * @author Julian Latendorf
 */

public class GameObject {
    private java.awt.Color color;
    protected int xPosition;
    protected int yPosition;
    protected int xSize;
    protected int ySize;
    protected GameLogic gameLog;

    /**
     * Konstruktor. Initialisiert GameLogic, Position, Größe und Farbe.
     *
     * @param gl Spiellogik
     * @param xp x-Position
     * @param yp y-Position
     * @param xs x-Größe
     * @param ys y-Größe
     * @param c Farbe
     */
    public GameObject(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        this.gameLog = gl;
        this.xPosition = xp;
        this.yPosition = yp;
        this.xSize = xs;
        this.ySize = ys;
        this.color = c;
    }

    /**
     * Setzt die Position des Objekts.
     *
     * @param x x-Position
     * @param y y-Position
     */
    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    /**
     * Gibt die x-Position zurück.
     *
     * @return x-Position
     */
    public int getX() {
        return this.xPosition;
    }

    /**
     * Gibt die y-Position zurück.
     *
     * @return y-Position
     */
    public int getY() {
        return this.yPosition;
    }

    /**
     * Gibt die x-Größe zurück.
     *
     * @return x-Größe
     */
    public int getXSize() {
        return this.xSize;
    }

    /**
     * Gibt die y-Größe zurück.
     *
     * @return y-Größe
     */
    public int getYSize() {
        return this.ySize;
    }

    /**
     * Gibt die Hitbox des Objekts zurück.
     *
     * @return Hitbox
     */
    public java.awt.Rectangle getHitBox() {
        Rectangle rec = new Rectangle(xPosition, yPosition, xSize, ySize);
        return rec;
    }
}
