package Shapes;

import Utils.Rules;
import Utils.Vector;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTest {

    @Test
    public void updateSpeed() {
        Rules.linesRemoved = 10;
        Shape shape = new ReverseZShape();
        shape.updateSpeed();
        Assert.assertEquals("Neatitinka greitis", 200, shape.getNormalSpeed());
    }

    @Test
    public void rotate() {
        Shape shape = new LShape();
        int[][][] rotations = new int[][][]{
                {{0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}},

                {{0, 1, 0},
                {0, 1, 0},
                {0, 1, 1}},

                {{0, 0, 0},
                {1, 1, 1},
                {1, 0, 0}},

                {{1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}},
        };


        shape.rotate();
        Assert.assertArrayEquals("Pirmas apsisukimas neteisingas", rotations[1], shape.getShape());
        shape.rotate();
        Assert.assertArrayEquals("Antras apsisukimas neteisingas", rotations[2], shape.getShape());
        shape.rotate();
        Assert.assertArrayEquals("Trecias apsisukimas neteisingas", rotations[3], shape.getShape());
        shape.rotate();
        Assert.assertArrayEquals("Ketvirtas apsisukimas neteisingas", rotations[0], shape.getShape());
    }

    @Test
    public void move() {
        Shape shape = new LShape();
        Vector shapeCoords = new Vector(2, -2);

        shape.move(-1, true);

        Assert.assertEquals("Figura nepajudejo i kaire", shapeCoords.getX(), shape.getCoordinates().getX());

        shape.move(1, true);

        shapeCoords.addX(1);

        Assert.assertEquals("Figura nepajudejo i desine", shapeCoords.getX(), shape.getCoordinates().getX());




    }
}