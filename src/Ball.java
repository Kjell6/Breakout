import java.awt.*;

/**
 * Repräsentiert den Ball im Spiel.
 *
 * @author Kjell Behrends
 * @author Julian Latendorf
 */
public class Ball extends GameObject {
    private int xVelocity;
    private int yVelocity;

    /**
     * Konstruktor. Initialisiert den Ball mit Position, Größe, Farbe,
     * GameLogic und Geschwindigkeit.
     *
     * @param gl die Spiellogik
     * @param xp x-Position
     * @param yp y-Position
     * @param xs x-Größe
     * @param ys y-Größe
     * @param c Farbe
     */
    public Ball(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        super(gl, xp, yp, xs, ys, c);
        xVelocity = Config.BALL_VELOCITY_MAX;
        yVelocity = - Config.BALL_VELOCITY_MAX;
    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRoundRect(xPosition - xSize / 2, yPosition - ySize / 2, xSize, ySize, 20, 20);
    }

    public void move() {
        xPosition += xVelocity;
        if (xPosition < 0) {
            xVelocity = -xVelocity;
        } else if (xPosition >= gameLog.getWidth()) {
            xVelocity = -xVelocity;
        }
        yPosition += yVelocity;
        if (yPosition < 0) {
            yVelocity = -yVelocity;
        } else if (yPosition >= gameLog.getHeight()) {
            yVelocity = -yVelocity;
        }
    }

    /**
     * Setzt die Geschwindigkeit des Balls.
     *
     * @param x x-Geschwindigkeit
     * @param y y-Geschwindigkeit
     */
    public void setVelocity(int x, int y) {
        this.xVelocity = x;
        this.yVelocity = y;
    }

    /**
     * Gibt die x-Geschwindigkeit zurück.
     *
     * @return x-Geschwindigkeit
     */
    public int getXVelocity() {
        return this.xVelocity;
    }

    /**
     * Gibt die y-Geschwindigkeit zurück.
     *
     * @return y-Geschwindigkeit
     */
    public int getYVelocity() {
        return yVelocity;
    }
}
