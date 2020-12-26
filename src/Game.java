import Utils.Rules;
import Utils.Time;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable{

    Thread gameThread;

    Board board;
    Input input;
    NextShapeController nextShape;
    Score score;


    public Game(){
        super.setDoubleBuffered(true);
        define();
        this.addKeyListener(input);
        this.setFocusable(true);
        gameThread.start();
    }

    void define(){
        input = new Input();
        gameThread = new Thread(this);
        nextShape = new NextShapeController();
        score = new Score();
        board = new Board(input, score, nextShape);
    }



    public void paint(Graphics gfx){
        super.paintComponent(gfx);
        draw(gfx);
    }



    void draw(Graphics gfx){
        board.drawBoard(gfx);
        nextShape.draw(gfx);
        score.draw(gfx);
    }


    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns= 1000000000 / amountOfTicks;
        double delta = 0;
        while (!Rules.isGameOver) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                Time.updateTime();
                board.update();
                repaint();

            }
        }
        new CloseGameDialog();
    }
}
