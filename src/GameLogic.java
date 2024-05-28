import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import static java.awt.Color.*;

public class GameLogic {
    private int ballCount;
    private int score;
    private Paddle paddle;
    private Ball ball;
    private List<Brick> bricks;
    private GameState gameState;

    public GameLogic(GameState gs) {
        ballCount = Configuration.BALL_COUNT_INITIAL;
        score = 0;
        paddle = new Paddle(this, Configuration.FIELD_X_SIZE / 2, Configuration.PADDLE_Y_POSITION,
                Configuration.PADDLE_X_SIZE, Configuration.PADDLE_Y_SIZE, Color.BLUE);
        ball = new Ball(this, Configuration.FIELD_X_SIZE, Configuration.PADDLE_Y_POSITION - 20,
                Configuration.BALL_X_SIZE, Configuration.BALL_Y_SIZE, WHITE);
        bricks = new LinkedList<>();
        gameState = gs;
    }

}
