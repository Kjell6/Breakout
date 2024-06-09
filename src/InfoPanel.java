import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.BLACK;

public class InfoPanel extends JPanel {
    private GameLogic logic;
    private Timer timer;
    private GameState gameState;
    private boolean gameOver;
    long startTime;
    long minutes;
    long seconds;
    long millis;

    public InfoPanel(GameLogic gl, GameState gs) {
        minutes = 0;
        seconds = 0;
        millis = 0;
        startTime = System.currentTimeMillis();

        this.logic = gl;
        this.gameState = gs;
        this.gameOver = false;
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(Configuration.FIELD_X_SIZE, Configuration.INFO_Y_SIZE));
    }

    public void start() {
        timer = new Timer(Configuration.LOOP_PERIOD, new GameLoop());
        timer.start();
    }


    private void onTick() {
        if (!gameOver) {
            elapsingTime();
            repaint();
        } else {
            repaint();
        }
    }

    public void elapsingTime() {
        long elapsedMillis = System.currentTimeMillis() - startTime;
        minutes = (elapsedMillis / 60000);
        seconds = (elapsedMillis / 1000) % 60;
        millis = elapsedMillis % 1000;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //Zeit
        graphics.setColor(Color.BLACK);
        String timeString = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        graphics.drawString(timeString, (Configuration.FIELD_X_SIZE - graphics.getFontMetrics(graphics.getFont()).stringWidth(timeString)) / 6,
                Configuration.INFO_Y_SIZE);

        //Bälle übrig
        graphics.setColor(BLACK);
        int ballSpace = 10;
        int dispBallX = (Configuration.FIELD_X_SIZE / 2) - ((Configuration.BALL_X_SIZE / 2) + ballSpace);
        for (int i = 0, j = 0; i < 3; i++, j += ballSpace) {
            if (i >= logic.getBallCount()) {
                graphics.setColor(new Color(0, 0, 0, 63));
                graphics.fillRect(dispBallX + j, Configuration.INFO_Y_SIZE / 2, Configuration.BALL_X_SIZE, Configuration.BALL_Y_SIZE);
            } else {
                graphics.setColor(new Color(0, 0, 0));
                graphics.fillRect(dispBallX + j, Configuration.INFO_Y_SIZE / 2, Configuration.BALL_X_SIZE, Configuration.BALL_Y_SIZE);
            }
        }

        //Score
        graphics.setColor(Color.BLACK);
        String score = String.format("%03d", logic.getScore());
        graphics.drawString(score, ((Configuration.FIELD_X_SIZE - graphics.getFontMetrics(graphics.getFont()).stringWidth(score)) / 6) * 5,
                Configuration.INFO_Y_SIZE);
    }

    private class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onTick();
        }
    }

    public void stop() {
        gameOver = true;
    }

    public String getTime() {
        return String.format("%02d:%02d:%03d", minutes, seconds, millis);
    }
}
