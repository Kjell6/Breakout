import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import static java.awt.Color.*;

/**
 * Klasse für die Logik des Spiels.
 *
 * @author Kjell Behrends
 * @author Julian Latendorf
 */
public class GameLogic extends JPanel {
    private int ballCount;
    private int score;
    private Paddle paddle;
    private Ball ball;
    private List<Brick> bricks;
    private GameState gameState;
    private static final Color[] COLORS = {new Color(209, 34, 38),
            new Color(30, 93, 25), new Color(52, 79, 206)};
    private Timer timer;
    InfoPanel infoP;


    /**
     * Konstruktor. Initialisiert GameState, Paddle, Ball und Bricks.
     * Setzt den Score auf 0 und legt den ballCount fest.
     *
     * @param gs der Spielzustand
     */
    public GameLogic(GameState gs) {
        ballCount = Configuration.BALL_COUNT_INITIAL;
        score = 0;
        paddle = new Paddle(this, Configuration.FIELD_X_SIZE / 2, Configuration.PADDLE_Y_POSITION,
                Configuration.PADDLE_X_SIZE, Configuration.PADDLE_Y_SIZE, new Color(144, 72, 176));
        ball = new Ball(this, Configuration.FIELD_X_SIZE / 2, Configuration.PADDLE_Y_POSITION - 100,
                Configuration.BALL_X_SIZE, Configuration.BALL_Y_SIZE, new Color(220, 232, 252));
        gameState = gs;


        bricks = new LinkedList<>();
        int brickCount = 0;
        int brickXSpace = Configuration.BRICK_SPACE;
        int brickYSpace = 20; //20 oder 10
        int height = Configuration.BRICK_Y_SIZE + brickXSpace;
        int width = Configuration.BRICK_X_SIZE * Configuration.BRICK_PER_ROW + ((Configuration.BRICK_PER_ROW - 1) * brickXSpace);
        int startX = (Configuration.FIELD_X_SIZE - width) / 2 + (Configuration.BRICK_X_SIZE / 2);
        int color = 0;

        for (int i = 0; i < Configuration.BRICK_ROWS; i++) {
            int yPosition = brickYSpace + i * height;
            if (color > 2) color = 0;

            for (int j = 0; j < Configuration.BRICK_PER_ROW; j++) {
                int xP = startX + j * (Configuration.BRICK_X_SIZE + brickXSpace);
                Brick brick = new Brick(this, xP, yPosition, Configuration.BRICK_X_SIZE, Configuration.BRICK_Y_SIZE, COLORS[color]);
                brickCount++;
                bricks.add(brick);
            }
            color++;
        }

        // set panel size
        setPreferredSize(new Dimension(Configuration.FIELD_X_SIZE, Configuration.FIELD_Y_SIZE));
        //Key Listener
        setFocusable(true);
        this.addKeyListener(new BreakoutKeyAdapter());
    }

    public void start() {
        gameState = GameState.RUNNING;
        timer = new Timer(Configuration.LOOP_PERIOD, new GameLoop());
        timer.start();
    }

    public void restartWithNewBall() {
        paddle.setVelocity(0);
        ball = new Ball(this, paddle.getX(), Configuration.PADDLE_Y_POSITION - 20,
                Configuration.BALL_X_SIZE, Configuration.BALL_Y_SIZE, new Color(220, 232, 252));

    }


    private void onTick() {
        ball.move();
        paddle.move();
        // check physics and rules
        if (ball.getHitBox().intersects(paddle.getHitBox())) { // ball hits paddle
            ball.setVelocity(ball.getXVelocity(), -ball.getYVelocity());
        } else if (ball.getY() > (Configuration.PADDLE_Y_POSITION + (Configuration.PADDLE_Y_SIZE / 2))) { // ball is lost
            // reduce number of balls
            --ballCount;
            if (ballCount <= 0) { // no balls left
                gameState = GameState.GAME_OVER;
                infoP.stop();
                String message = String.format(
                        "<html><body style='text-align: center;'>"
                                + "<h2 style='color: red;'>Game Over</h2>"
                                + "<p><b>Score:</b> %d</p>"
                                + "<p><b>Time:</b> %s</p>"
                                + "</body></html>", score, infoP.getTime());

                JLabel label = new JLabel(message);
                Icon icon = new ImageIcon("losing.png");
                JOptionPane.showMessageDialog(this, message,"Game Over",
                        JOptionPane.PLAIN_MESSAGE, icon);

                System.exit(-1);
            } else { // at least one ball left, continue level
                restartWithNewBall();
            }
        }

        Rectangle ballHitBox = ball.getHitBox();

        Rectangle nextX = new Rectangle(ballHitBox);
        nextX.setLocation(nextX.x + ball.getXVelocity(), nextX.y);

        Rectangle nextY = new Rectangle(ballHitBox);
        nextY.setLocation(nextY.x, nextY.y + ball.getYVelocity());

        Brick hitBrick = null;

        for (Brick brick : bricks) {
            if (brick.getHitBox().intersects(nextX)) { // hit in the west or east
                ball.setVelocity(-ball.getXVelocity(), ball.getYVelocity());
                hitBrick = brick;
                break;
            }
            if (brick.getHitBox().intersects(nextY)) { // hit in the north or south
                ball.setVelocity(ball.getXVelocity(), -ball.getYVelocity());
                hitBrick = brick;
                break;
            }
        }

        if (hitBrick != null) { // if hit brick then remove it and score
            bricks.remove(hitBrick);
            score += Configuration.BRICK_SCORE;
        }

        //System.out.println("onTick");
        repaint();

        if (((Configuration.BRICK_ROWS * Configuration.BRICK_PER_ROW) * Configuration.BRICK_SCORE) == score) {
            gameState = GameState.GAME_OVER;
            infoP.stop();
            String message = String.format(
                    "<html><body style='text-align: center;'>"
                            + "<h2 style='color: #FFD700;'>Game Won</h2>"
                            + "<p><b>Score:</b> %d</p>"
                            + "<p><b>Time:</b> %s</p>"
                            + "</body></html>", score, infoP.getTime());

            JLabel label = new JLabel(message);
            Icon icon = new ImageIcon("winning.png");
            JOptionPane.showMessageDialog(this, message,"Game Won",
                    JOptionPane.PLAIN_MESSAGE, icon);

            System.exit(-1);
        }
    }

    private class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onTick();
        }
    }

    //Tasten
    private class BreakoutKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            onKeyPressed(event);
        }

        @Override
        public void keyReleased(KeyEvent event) {
            onKeyReleased(event);
        }
    }

    void onKeyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            paddle.setVelocity(-Configuration.PADDLE_VELOCITY);
        }
        if (key == KeyEvent.VK_RIGHT) {
            paddle.setVelocity(Configuration.PADDLE_VELOCITY);
        }
    }

    void onKeyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            paddle.setVelocity(0);
        }
    }


    @Override
    public void paintComponent(Graphics graphics) {
        // paint panel
        super.paintComponent(graphics);
        // configure rendering pipeline: Enable antialiasing and high render quality
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        /*
        Image image = new ImageIcon("/Users/kjell/Downloads/Pinterest Image.jpg").getImage();
        graphics.drawImage(image, 0, 0, this);
         */
        graphics.setColor(BLACK);
        graphics.fillRoundRect(0, 0, Configuration.FIELD_X_SIZE, Configuration.FIELD_Y_SIZE, 15, 15);
        // render bricks, paddle, and ball
        for (Brick brick : bricks) {
            brick.render(graphics);
        }
        paddle.render(graphics);
        ball.render(graphics);
        // synchronize graphics state
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setInfoP(InfoPanel ip) {
        this.infoP = ip;
    }

    public int getScore() {
        return this.score;
    }

}
