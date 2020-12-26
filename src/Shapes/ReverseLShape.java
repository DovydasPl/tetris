package Shapes;

public class ReverseLShape extends Shape {

    public ReverseLShape(){
        super(new int[][]{{1, 0, 0}, {1, 1, 1}, {0, 0, 0}}, 5,
                new int[][][]{
                        {{1, 0, 0},
                         {1, 1, 1},
                         {0, 0, 0}},

                        {{0, 1, 1},
                         {0, 1, 0},
                         {0, 1, 0}},

                        {{0, 0, 0},
                         {1, 1, 1},
                         {0, 0, 1}},

                        {{0, 1, 0},
                         {0, 1, 0},
                         {1, 1, 0}},
                });
    }

    @Override
    public Shape makeCopy() {
        return new ReverseLShape();
    }
}
