package Shapes;

public class SquareShape extends Shape {

    public SquareShape(){
        super(new int[][]{{1, 1}, {1, 1}}, 7,
                new int[][][]{
                {{1, 1}, {1, 1}}
        });
    }

    @Override
    public Shape makeCopy() {
        return new SquareShape();
    }
}
