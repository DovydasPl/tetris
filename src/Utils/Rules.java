package Utils;

public class Rules {

    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;

    public static final int BORDER_WIDTH = 5;

    public static final int SQUARE_SIZE = 35;

    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 800;

    public static final int BOARD_POINT_X = 65;
    public static final int BOARD_POINT_Y = 30;

    public static final int NEXT_SHAPE_HEIGHT = 4;
    public static final int NEXT_SHAPE_WIDTH = 6;

    public static final int NEXT_SHAPE_POINT_X = BOARD_POINT_X + SQUARE_SIZE * BOARD_WIDTH + BORDER_WIDTH + 30;
    public static final int NEXT_SHAPE_POINT_Y = BOARD_POINT_Y;

    public static final int SCORE_POINT_X = NEXT_SHAPE_POINT_X;
    public static final int SCORE_POINT_Y = NEXT_SHAPE_POINT_Y + NEXT_SHAPE_HEIGHT*SQUARE_SIZE + BORDER_WIDTH + 30;

    public static boolean isGameOver = false;

    public static int linesRemoved = 0;
}
