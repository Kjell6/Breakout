import java.awt.*;

/**
 * Repräsentiert einen Brick im Spiel.
 *
 * @author Kjell Behrends
 * @author Julian Latendorf
 */
public class Brick extends GameObject {
    private boolean destroyed;

    /**
     * Konstruktor. Initialisiert den Brick mit Position, Größe, Farbe, Spiellogik und
     * Destroyed Status.
     *
     * @param gl die Spiellogik
     * @param xp x-Position
     * @param yp y-Position
     * @param xs x-Größe
     * @param ys y-Größe
     * @param c Farbe
     */
    public Brick(GameLogic gl, int xp, int yp, int xs, int ys, Color c) {
        super(gl, xp, yp, xs, ys, c);
        destroyed = false;
    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(xPosition - xSize / 2, yPosition - ySize / 2, xSize, ySize);
    }


    /**
     * Überprüft, ob der Brick zerstört ist.
     *
     * @return true, wenn der Brick zerstört ist, sonst false
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Setzt den Brick auf zerstört.
     */
    public void setDestroyed() {
        this.destroyed = true;
    }

    /**
     * Setzt den Brick auf intakt.
     */
    public void setIntact() {
        this.destroyed = false;
    }
}
