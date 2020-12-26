import Shapes.*;
import Shapes.Shape;
import Utils.ColorID;
import Utils.Rules;
import Utils.Vector;

import java.awt.*;
import java.util.Random;

public class Board {


    public int[][] board;

    Input input;
    NextShapeController nextShapeController;
    Score score;
    private final Shape[] shapes;

    private Shape currentShape;

    private final Random rand;
    private int nextRandNumber;

    public Board(Input in, Score s, NextShapeController nsc){

        board = new int [Rules.BOARD_HEIGHT][Rules.BOARD_WIDTH];
        input = in;
        nextShapeController = nsc;
        score = s;
        shapes = new Shape[]{
                new IShape(),//I shape
                new ZShape(),//Z shape
                new ReverseZShape(),//Z reverse shape
                new LShape(),//L shape
                new ReverseLShape(),//L reverse shape
                new TShape(),//T shape
                new SquareShape(),//Square shape

        };

        rand = new Random();
        nextRandNumber = rand.nextInt(7);

        setNextShape();
        nextShapeController.setNextShape(getNextShape());

    }

    public void setNextShape(){
        currentShape = shapes[nextRandNumber].makeCopy();

        nextRandNumber = rand.nextInt(7);

    }

    public Shape getNextShape(){
        return shapes[nextRandNumber].makeCopy();
    }


    private void drawBackground(Graphics gfx){
        //draw background
        gfx.setColor(ColorID.getColorById(9));
        gfx.fillRect(0,0, Rules.SCREEN_WIDTH, Rules.SCREEN_HEIGHT);
        //draw game borders
        gfx.setColor(ColorID.getColorById(10));
        gfx.fillRect(Rules.BOARD_POINT_X - Rules.BORDER_WIDTH, Rules.BOARD_POINT_Y - Rules.BORDER_WIDTH, Rules.BORDER_WIDTH, Rules.BORDER_WIDTH * 2 + Rules.SQUARE_SIZE * Rules.BOARD_HEIGHT);
        gfx.fillRect(Rules.BOARD_POINT_X + Rules.BOARD_WIDTH* Rules.SQUARE_SIZE, Rules.BOARD_POINT_Y - Rules.BORDER_WIDTH, Rules.BORDER_WIDTH, Rules.BORDER_WIDTH * 2 + Rules.SQUARE_SIZE * Rules.BOARD_HEIGHT);
        gfx.fillRect(Rules.BOARD_POINT_X, Rules.BOARD_POINT_Y - Rules.BORDER_WIDTH, Rules.BORDER_WIDTH+ Rules.SQUARE_SIZE * Rules.BOARD_WIDTH, Rules.BORDER_WIDTH);
        gfx.fillRect(Rules.BOARD_POINT_X, Rules.BOARD_POINT_Y + Rules.SQUARE_SIZE * Rules.BOARD_HEIGHT, Rules.BORDER_WIDTH+ Rules.SQUARE_SIZE * Rules.BOARD_WIDTH, Rules.BORDER_WIDTH);
    }

    private void drawFilledBoard(Graphics gfx){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != 0){
                    gfx.setColor(ColorID.getColorById(board[i][j]));
                    gfx.fillRect(Rules.BOARD_POINT_X + j * Rules.SQUARE_SIZE, Rules.BOARD_POINT_Y + i * Rules.SQUARE_SIZE, Rules.SQUARE_SIZE, Rules.SQUARE_SIZE);
                }
            }
        }
    }

    private void drawGrid(Graphics gfx){
        gfx.setColor(ColorID.getColorById(8));

        for(int i = 1; i < Rules.BOARD_HEIGHT; i++){
            gfx.drawRect(Rules.BOARD_POINT_X, Rules.BOARD_POINT_Y + i * Rules.SQUARE_SIZE, Rules.SQUARE_SIZE * Rules.BOARD_WIDTH, 1);
        }
        for(int i = 1; i < Rules.BOARD_WIDTH; i++) {
            gfx.drawRect(Rules.BOARD_POINT_X + i * Rules.SQUARE_SIZE, Rules.BOARD_POINT_Y, 1, Rules.SQUARE_SIZE * Rules.BOARD_HEIGHT);
        }
    }

    public void drawBoard(Graphics gfx){
        drawBackground(gfx);
        drawFilledBoard(gfx);
        currentShape.draw(gfx);
        drawGrid(gfx);
    }


    private boolean checkIfGameOver(){
        return currentShape.getCoordinates().getY() < 0;
    }

    public void update(){
        int moveX = 0;

        if(isIntersecting()){
            putCurrentShapeIn();
            if(checkIfGameOver()){
                Rules.isGameOver = true;
                return;
            }
            setNextShape();
            nextShapeController.setNextShape(getNextShape());
        }

        if(input.GetKeyDown(Keycodes.W)){
            rotateShape();
        }


        if (input.GetKeyDown(Keycodes.D)) {
            moveX = 1;
        }
        if (input.GetKeyDown(Keycodes.A)) {
            moveX = -1;
        }

        moveShape(moveX, input.GetKey(Keycodes.S));
    }

    public void rotateShape(){
        int[][] nextRotation = currentShape.getNextRotation();
        Vector shapeCoords = currentShape.getCoordinates();

        if(shapeCoords.getX() + currentShape.getMostRightRotatedShapePart() >= Rules.BOARD_WIDTH || shapeCoords.getX() + currentShape.getMostLeftRotatedShapePart() < 0 || shapeCoords.getY() + nextRotation.length > Rules.BOARD_HEIGHT){
            return;
        }

        for(int i = 0; i < nextRotation.length; i++){
            for(int j = 0; j < nextRotation[0].length; j++){
                if(shapeCoords.getY() + i < 0) continue;
                if(board[shapeCoords.getY() + i][shapeCoords.getX() + j] != 0 ){
                    return;
                }
            }
        }
        currentShape.rotate();
    }

    private boolean isShapeHorizontallyHittingBoardContent(int i, int j, int moveX){
        Vector shapeCoords = currentShape.getCoordinates();
        int[][] shape = currentShape.getShape();

        if (shape[i][j] != 0 && shapeCoords.getY() + i >= 0) {
            if(board[shapeCoords.getY() + i][j + shapeCoords.getX() + moveX] != 0){
                return true;
            }
        }
        return false;
    }

    private boolean canMoveHorizontally(int moveX){
        Vector shapeCoords = currentShape.getCoordinates();

        if((shapeCoords.getX() + moveX + currentShape.getMostRightShapePart() >= Rules.BOARD_WIDTH) || (shapeCoords.getX() + moveX + currentShape.getMostLeftShapePart() < 0)){
            return false;
        }

        int[][] shape = currentShape.getShape();

        for(int i = 0; i < shape.length; i++){
            for(int j = 0; j < shape[i].length; j++){
                if(isShapeHorizontallyHittingBoardContent(i, j, moveX)){
                    return false;
                }
            }
        }

        return true;
    }

    public void moveShape(int moveX, boolean boosting){
        if(canMoveHorizontally(moveX)){
            currentShape.move(moveX, boosting);

        }
    }


    public void putCurrentShapeIn(){
        int[][] shape = currentShape.getShape();

        Vector shapeCoords = currentShape.getCoordinates();
        for(int i = 0; i < shape.length; i++){
            for(int j = 0; j < shape[i].length; j++){
                if(shape[i][j] != 0 && shapeCoords.getY() + i >= 0){
                    board[i + shapeCoords.getY()][j + shapeCoords.getX()] = currentShape.getID();
                }
            }
        }

        checkLines();
    }

    private void checkLines(){
        int height = board.length - 1;

        for(int i = height; i > 0; i--){
            int count = 0;
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != 0) count++;

                board[height][j] = board[i][j];
            }
            if(count < board[0].length) height--;
        }
        Rules.linesRemoved += height;
        currentShape.updateSpeed();
        score.updateScore();
    }

    private boolean isShapeVerticallyHittingBoardBottom(){
        Vector shapeCoords = currentShape.getCoordinates();

        return !(shapeCoords.getY() + currentShape.getMostBottomShapePart() + 1 < Rules.BOARD_HEIGHT);
    }

    private boolean isShapeVerticallyHittingBoardContent(int i, int j){
        int[][] shape = currentShape.getShape();
        Vector shapeCoords = currentShape.getCoordinates();

        if (shape[i][j] != 0 && shapeCoords.getY() + i + 1 >= 0) {
            if(board[shapeCoords.getY() + i + 1][j + shapeCoords.getX()] != 0){
                return true;
            }
        }
        return false;
    }

    public boolean isIntersecting(){
        int[][] shape = currentShape.getShape();

        if(isShapeVerticallyHittingBoardBottom()){
            return true;
        }

        for(int i = 0; i < shape.length; i++){
            for(int j = 0; j < shape[i].length; j++){
                if(isShapeVerticallyHittingBoardContent(i, j)){
                    return true;
                }
            }
        }
        return false;
    }


}
