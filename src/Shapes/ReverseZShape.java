package Shapes;

public class ReverseZShape extends Shape {

    public ReverseZShape(){
        super(new int[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}},
        3,
            new int[][][]{
                    {{0, 1, 1},
                     {1, 1, 0},
                     {0, 0, 0}},

                    {{0, 1, 0},
                     {0, 1, 1},
                     {0, 0, 1}},

                    {{0, 0, 0},
                     {0, 1, 1},
                     {1, 1, 0}},

                    {{1, 0, 0},
                     {1, 1, 0},
                     {0, 1, 0}},
        });
    }

    @Override
    public Shape makeCopy() {
        return new ReverseZShape();
    }
}
