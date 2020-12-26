import javax.swing.*;
import java.awt.*;

public class CloseGameDialog extends JFrame {
    public CloseGameDialog(){
        JButton button = new JButton("You lost! Press here to close the game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(button);
        button.addActionListener(e -> {
            this.dispose();
            System.exit(0);

        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(300, 200));
        this.setLocation(1920/2 - 150, 1080/2 - 100);

        this.getContentPane().setBackground(Color.white);
        this.pack();
        this.setVisible(true);
    }
}
