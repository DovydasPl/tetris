package Shapes;

import Utils.ColorID;
import Utils.Rules;
import Utils.Time;
import Utils.Vector;

import java.awt.*;

public abstract class Shape {
    private int ID;
    private int[][] shape;
    private int[][][] rotations;
    private int currentRotation;
    private Color color;
    private Vector coordinates;

    private long timer;
    private int normalSpeed = 300, speedDown = 30, minimumSpeed = 30, maxSpeed = 300, currentSpeed = normalSpeed;


    public Shape(int[][] s, int id, int[][][] r) {
        shape = s;
        color = ColorID.getColorById(id);
        ID = id;
        coordinates = new Vector(3,-2);
        rotations = r;
        currentRotation = 0;
        timer = 0;
        updateSpeed();
    }

    public abstract Shape makeCopy();

    public void updateSpeed(){
        normalSpeed = maxSpeed - Rules.linesRemoved * 10;
        if(normalSpeed < minimumSpeed){
            normalSpeed = minimumSpeed;
        }
    }

    public int[][] getNextRotation(){
        int nextRotation = 0;
        if(currentRotation < rotations.length - 1){
            nextRotation = currentRotation + 1;
        }
        return rotations[nextRotation];
    }

    public void rotate(){
        shape = getNextRotation();
        currentRotation++;
        if(currentRotation > rotations.length - 1){
            currentRotation = 0;
        }
    }


    public Color getColor(){
        return color;
    }

    public void draw(Graphics gfx){
        for(int i = 0; i < shape.length; i++){
            for(int j = 0; j < shape[i].length; j++){
                if(shape[i][j] != 0 && i + coordinates.getY() >= 0){
                    gfx.setColor(color);
                    gfx.fillRect(j* Rules.SQUARE_SIZE+ Rules.BOARD_POINT_X+coordinates.getX()* Rules.SQUARE_SIZE, i* Rules.SQUARE_SIZE+ Rules.BOARD_POINT_Y+coordinates.getY()* Rules.SQUARE_SIZE, Rules.SQUARE_SIZE, Rules.SQUARE_SIZE);
                }
            }
        }
    }

    public int getMostBottomShapePart(){
        for(int i = shape.length - 1; i >= 0; i--){
            for(int j = 0; j < shape.length; j++){
                if(shape[i][j] == 1){
                    return i;
                }
            }
        }
        return shape.length - 1;
    }

    public int getMostLeftShapePart(){
        return getMostLeftGivenShapePart(shape);
    }

    public int getMostRightShapePart(){
        return getMostRightGivenShapePart(shape);
    }

    public int getMostLeftRotatedShapePart(){
        return getMostLeftGivenShapePart(getNextRotation());
    }

    public int getMostRightRotatedShapePart(){
        return getMostRightGivenShapePart(getNextRotation());
    }

    private int getMostLeftGivenShapePart(int[][] s){
        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < s.length; j++){
                if(s[j][i] == 1){
                    return i;
                }
            }
        }
        return 0;
    }

    private int getMostRightGivenShapePart(int[][] s){
        for(int i = s.length - 1; i >= 0; i--){
            for(int j = 0; j < s.length; j++){
                if(s[j][i] == 1){
                    return i;
                }
            }
        }
        return s.length - 1;
    }

    public void move(int moveX, boolean boosting){
        currentSpeed = (boosting)?speedDown:normalSpeed;
        coordinates.addX(moveX);

        timer += Time.getTickTime();

        if(timer >= currentSpeed){
            goDown();
            timer = 0;
        }
    }

    private void goDown(){
        coordinates.addY(1);
    }

    public int[][] getShape(){
        return shape;
    }

    public Vector getCoordinates(){
        return coordinates;
    }

    public int getID(){ return ID; }



    public int getNormalSpeed(){
        return normalSpeed;
    }
}
