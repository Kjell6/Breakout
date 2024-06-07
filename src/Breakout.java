import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Breakout {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Break Out");
        // exit application on close
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // show window in the center of the screen
        frame.setLocationRelativeTo(null);
        // window is not resizable
        frame.setResizable(false);
        // arrange components
        frame.pack();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        GameState state = GameState.SETUP;
        // create game logic object
        GameLogic gameLogic = new GameLogic(state);
        JPanel gamePanel = new JPanel();
        gamePanel.add(gameLogic);

        InfoPanel infoPanel = new InfoPanel();

        // add panel to window
        gbc.gridy = 1;
        frame.add(gamePanel, gbc);
        gbc.gridy = 0;
        frame.add(infoPanel, gbc);
        frame.pack();
        frame.setVisible(true);
        gameLogic.start();
        infoPanel.start();
        // show window
        frame.setVisible(true);
    }
}


