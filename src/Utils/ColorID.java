package Utils;

import java.awt.*;

public class ColorID {
    private static Color[] colors = new Color[]{Color.red, Color.blue, Color.green, Color.pink, Color.yellow, Color.magenta, Color.cyan, Color.gray, Color.black, Color.darkGray};
    public static Color getColorById(int id){
            return colors[id-1];
    }
}
