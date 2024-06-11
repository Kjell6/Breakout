/**
 * Konfigurationsklasse für das Spiel.
 * Enthält Konstanten für verschiedene Einstellungen im Spiel.
 *
 * @author Kjell Behrends
 * @author Julian Latendorf
 */
public class Configuration {
    public static int BALL_COUNT_INITIAL = 3;
    public static final int LOOP_PERIOD = 10;
    public static final int FIELD_X_SIZE = 320;
    public static final int FIELD_Y_SIZE = 320;
    public static final int PADDLE_Y_POSITION = FIELD_Y_SIZE - 20;
    public static final int PADDLE_X_SIZE = 32;
    public static final int PADDLE_Y_SIZE = 8;
    public static final int PADDLE_VELOCITY = 2;
    public static final int BALL_X_SIZE = 5;
    public static final int BALL_Y_SIZE = 5;
    public static final int BALL_VELOCITY_MAX = 1;
    public static final int BRICK_X_SIZE = 59; //59 oder 25
    public static final int BRICK_Y_SIZE = 25; //25 oder 10
    public static final int BRICK_SCORE = 10;
    public static final int BRICK_ROWS = 3;
    public static final int BRICK_PER_ROW = 4; //4 oder 10
    public static final int INFO_Y_SIZE = 20;
}