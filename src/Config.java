/**
 * Konfigurationsklasse für das Spiel.
 * Enthält Konstanten für verschiedene Einstellungen im Spiel.
 *
 * @author Kjell Behrends
 * @author Julian Latendorf
 */
public class Config {
    public static final int BALL_COUNT_INITIAL = 3;
    public static final int LOOP_PERIOD = 10;
    public static final int FIELD_X_SIZE = 320;
    public static final int FIELD_Y_SIZE = 320;
    public static final int PADDLE_Y_POSITION = FIELD_Y_SIZE - 20;
    public static final int PADDLE_X_SIZE = FIELD_X_SIZE / 10;
    public static final int PADDLE_Y_SIZE = FIELD_X_SIZE / 40;
    public static final int PADDLE_VELOCITY = 2;
    public static final int BALL_X_SIZE = FIELD_X_SIZE / 64;
    public static final int BALL_Y_SIZE = FIELD_X_SIZE / 64;
    public static final int BALL_VELOCITY_MAX = 1;
    public static final int BRICK_ROWS = 3; //3
    public static final int BRICK_PER_ROW = 4; //4
    public static final int BRICK_SPACE = 5;
    public static final int BRICK_X_SIZE = (FIELD_X_SIZE - 50 - (BRICK_PER_ROW * BRICK_SPACE)) / BRICK_PER_ROW; //59 oder 25
    public static final int BRICK_Y_SIZE = 100 / BRICK_PER_ROW; //25 oder 10
    public static final int BRICK_SCORE = 10;
    public static final int INFO_Y_SIZE = 20;
}