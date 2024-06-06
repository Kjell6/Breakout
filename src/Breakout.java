import javax.swing.*;
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


        GameState state = GameState.SETUP;
        // create game logic object
        GameLogic gameLogic = new GameLogic(state);
        // add panel to window
        frame.add(gameLogic);
        frame.pack();
        frame.setVisible(true);
        gameLogic.start();
        // show window
        frame.setVisible(true);

    }
}


