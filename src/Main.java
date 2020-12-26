import Utils.Rules;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Game game = new Game();
        obj.setTitle("Game");
        obj.setResizable(false);
        obj.setSize(Rules.SCREEN_WIDTH, Rules.SCREEN_HEIGHT);
        obj.setLocation(1920/2 - 400, 1080/2 - 300);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.add(game);
    }
}
