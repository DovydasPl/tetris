import Shapes.Shape;
import Utils.ColorID;
import Utils.Rules;

import java.awt.*;

public class NextShapeController {
    private Shape nextShape;

    public void draw(Graphics gfx){

        //draw borders
        drawBorders(gfx);
        //draw shape
        drawShape(gfx);
        //draw grid`
        drawGrid(gfx);

    }

    private void drawGrid(Graphics gfx){
        gfx.setColor(ColorID.getColorById(8));

        for(int i = 1; i < Rules.NEXT_SHAPE_HEIGHT; i++){
            gfx.drawRect(Rules.NEXT_SHAPE_POINT_X, Rules.NEXT_SHAPE_POINT_Y + i * Rules.SQUARE_SIZE, Rules.SQUARE_SIZE * Rules.NEXT_SHAPE_WIDTH, 1);
        }
        for(int i = 1; i < Rules.NEXT_SHAPE_WIDTH; i++) {
            gfx.drawRect(Rules.NEXT_SHAPE_POINT_X + i * Rules.SQUARE_SIZE, Rules.NEXT_SHAPE_POINT_Y, 1, Rules.SQUARE_SIZE * Rules.NEXT_SHAPE_HEIGHT);
        }
    }

    private void drawBorders(Graphics gfx){
        gfx.setColor(ColorID.getColorById(10));
        gfx.fillRect(Rules.NEXT_SHAPE_POINT_X - Rules.BORDER_WIDTH, Rules.NEXT_SHAPE_POINT_Y - Rules.BORDER_WIDTH, Rules.BORDER_WIDTH, Rules.BORDER_WIDTH * 2 + Rules.SQUARE_SIZE * Rules.NEXT_SHAPE_HEIGHT);
        gfx.fillRect(Rules.NEXT_SHAPE_POINT_X + Rules.NEXT_SHAPE_WIDTH* Rules.SQUARE_SIZE, Rules.NEXT_SHAPE_POINT_Y - Rules.BORDER_WIDTH, Rules.BORDER_WIDTH, Rules.BORDER_WIDTH * 2 + Rules.SQUARE_SIZE * Rules.NEXT_SHAPE_HEIGHT);
        gfx.fillRect(Rules.NEXT_SHAPE_POINT_X, Rules.NEXT_SHAPE_POINT_Y - Rules.BORDER_WIDTH, Rules.BORDER_WIDTH+ Rules.SQUARE_SIZE * Rules.NEXT_SHAPE_WIDTH, Rules.BORDER_WIDTH);
        gfx.fillRect(Rules.NEXT_SHAPE_POINT_X, Rules.NEXT_SHAPE_POINT_Y + Rules.SQUARE_SIZE * Rules.NEXT_SHAPE_HEIGHT, Rules.BORDER_WIDTH+ Rules.SQUARE_SIZE * Rules.NEXT_SHAPE_WIDTH, Rules.BORDER_WIDTH);
    }

    private  void drawShape(Graphics gfx){
        int[][] shape = nextShape.getShape();
        for(int i = 0; i < shape.length; i++){
            for(int j = 0; j < shape[i].length; j++){
                if(shape[i][j] != 0){
                    gfx.setColor(nextShape.getColor());
                    gfx.fillRect(j* Rules.SQUARE_SIZE+ Rules.SQUARE_SIZE+ Rules.NEXT_SHAPE_POINT_X, i* Rules.SQUARE_SIZE+ Rules.SQUARE_SIZE+ Rules.NEXT_SHAPE_POINT_Y, Rules.SQUARE_SIZE, Rules.SQUARE_SIZE);
                }
            }
        }
    }

    public void setNextShape(Shape shape){
        nextShape = shape;
    }
}
