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

    public InfoPanel() {
        this.timeDisplay = new TimeDisplay(logic);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(Configuration.FIELD_X_SIZE, Configuration.INFO_Y_SIZE));
    }

    public void updateInfo() {
        timeDisplay.elapsingTime();
    }

    public void start() {
        timer = new Timer(Configuration.LOOP_PERIOD, new GameLoop());
        timer.start();
    }


    private void onTick() {
        updateInfo();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        timeDisplay.render(g);
    }

    private class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onTick();
        }
    }
}
