package Shapes;

public class ZShape extends Shape {

    public ZShape(){
        super(new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}}, 2,
                new int[][][]{
                        {{1, 1, 0},
                         {0, 1, 1},
                         {0, 0, 0}},

                        {{0, 0, 1},
                         {0, 1, 1},
                         {0, 1, 0}},

                        {{0, 0, 0},
                         {1, 1, 0},
                         {0, 1, 1}},

                        {{0, 1, 0},
                         {1, 1, 0},
                         {1, 0, 0}},
                });
    }

    @Override
    public Shape makeCopy() {
        return new ZShape();
    }
}
