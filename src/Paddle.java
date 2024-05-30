import java.awt.*;

/**
 * Repräsentiert das Paddle im Spiel.
 *
 * @author Kjell Behrends
 * @author Julian Latendorf
 */
public class Paddle extends GameObject {
    private int xVelocity;

    /**
     * Konstruktor. Initialisiert das Paddle mit Position, Größe, Farbe, GameLogic und
     * setz die Geschwindigkeit auf 0.
     *
     * @param gl die Spiellogik
     * @param xp x-Position
     * @param yp y-Position
     * @param xs x-Größe
     * @param ys y-Größe
     * @param c Farbe
     */
    public Paddle(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        super(gl, xp, yp, xs, ys, c);
        xVelocity = 0;
    }

    /**
     * Setzt die x-Geschwindigkeit des Paddles.
     *
     * @param xv x-Geschwindigkeit
     */
    public void setVelocity(int xv) {
        this.xVelocity = xv;
    }
}
