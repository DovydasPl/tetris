package Shapes;

public class TShape extends Shape {

    public TShape(){
        super(new int[][]{{0, 1, 0}, {1, 1, 1}, {0,0,0}}, 6,
                new int[][][]{
                        {{0, 1, 0},
                         {1, 1, 1},
                         {0, 0, 0}},

                        {{0, 1, 0},
                         {0, 1, 1},
                         {0, 1, 0}},

                        {{0, 0, 0},
                         {1, 1, 1},
                         {0, 1, 0}},

                        {{0, 1, 0},
                         {1, 1, 0},
                         {0, 1, 0}},
                });
    }

    @Override
    public Shape makeCopy() {
        return new TShape();
    }
}
