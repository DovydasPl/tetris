package Shapes;

public class LShape extends Shape {

    public LShape(){
        super(new int[][]{{0, 0, 1}, {1, 1, 1}, {0, 0, 0}}, 4,
                new int[][][]{
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
        });
    }

    @Override
    public Shape makeCopy() {
        return new LShape();
    }
}
