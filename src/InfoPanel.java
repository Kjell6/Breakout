import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.BLACK;

public class InfoPanel extends JPanel {
    private TimeDisplay timeDisplay;
    private JLabel livesLabel;
    private GameLogic logic;
    private Timer timer;

    public InfoPanel(GameLogic gl) {
        this.logic = gl;
        this.timeDisplay = new TimeDisplay(logic);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(Configuration.FIELD_X_SIZE, Configuration.INFO_Y_SIZE));
    }

    public void start() {
        timer = new Timer(Configuration.LOOP_PERIOD, new GameLoop());
        timer.start();
    }


    private void onTick() {
        timeDisplay.elapsingTime();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        timeDisplay.render(graphics);
        graphics.setColor(BLACK);

        int dispBallX = ((Configuration.FIELD_X_SIZE / 4) * 3) - (Configuration.BALL_X_SIZE * 3 + 2 * 10);
        for (int i = 0, j = 0; i < logic.getBallCount(); i++, j += 10) {
            graphics.fillRect(dispBallX + j, Configuration.INFO_Y_SIZE / 2, Configuration.BALL_X_SIZE, Configuration.BALL_Y_SIZE);
        }
    }

    private class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onTick();
        }
    }
}
