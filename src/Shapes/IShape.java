package Shapes;

public class IShape extends Shape {

    public IShape(){
        super(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0},{0, 0, 0, 0}}, 1,
                new int[][][]{
                        {{0, 0, 0, 0},
                         {1, 1, 1, 1},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0}},

                        {{0, 0, 1, 0},
                         {0, 0, 1, 0},
                         {0, 0, 1, 0},
                         {0, 0, 1, 0}},

                        {{0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {1, 1, 1, 1},
                         {0, 0, 0, 0}},

                        {{0, 1, 0, 0},
                         {0, 1, 0, 0},
                         {0, 1, 0, 0},
                         {0, 1, 0, 0}},
                });
    }

    @Override
    public Shape makeCopy() {
        return new IShape();
    }
}
