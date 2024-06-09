import java.awt.*;

public class TimeDisplay {
    GameLogic logic;
    long minutes;
    long seconds;
    long millis;
    long startTime;

    public TimeDisplay(GameLogic gl) {
        this.logic = gl;
        minutes = 0;
        seconds = 0;
        millis = 0;
        startTime = System.currentTimeMillis(); // Startzeit
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        String timeString = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        g.drawString(timeString, (Configuration.FIELD_X_SIZE - g.getFontMetrics(g.getFont()).stringWidth(timeString)) / 4,
                Configuration.INFO_Y_SIZE);
    }

    public void elapsingTime() {
        long elapsedMillis = System.currentTimeMillis() - startTime;
        minutes = (elapsedMillis / 60000);
        seconds = (elapsedMillis / 1000) % 60;
        millis = elapsedMillis % 1000;
    }

    public String toString() {
        return String.format("%02d:%02d:%03d", minutes, seconds, millis);
    }

}
