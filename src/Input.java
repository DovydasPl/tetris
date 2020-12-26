import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {

    private Key[] keys;

    public Input(){
        keys = new Key[]{
                new Key("W", false, false),
                new Key("A", false, false),
                new Key("S", false, false),
                new Key("D", false, false),
                new Key("ARROW_UP", false, false),
                new Key("ARROW_DOWN", false, false),
                new Key("ARROW_RIGHT", false, false),
                new Key("ARROW_LEFT", false, false)

        };

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            keys[0].pressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keys[1].pressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            keys[2].pressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            keys[3].pressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            keys[4].pressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            keys[5].pressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            keys[6].pressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            keys[7].pressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            keys[0].pressed = false;
            keys[0].isDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keys[1].pressed = false;
            keys[1].isDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            keys[2].pressed = false;
            keys[2].isDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            keys[3].pressed = false;
            keys[3].isDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            keys[4].pressed = false;
            keys[4].isDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            keys[5].pressed = false;
            keys[5].isDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            keys[6].pressed = false;
            keys[6].isDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            keys[7].pressed = false;
            keys[7].isDown = false;
        }

    }

    public boolean GetKey(Keycodes k){

        return keys[k.getValue()].pressed;
    }

    public boolean GetKeyDown(Keycodes k){
        if(keys[k.getValue()].pressed && !keys[k.getValue()].isDown){
            keys[k.getValue()].isDown = true;
            return true;
        }else{
            return false;
        }
    }

    public class Key {
        String keyName;
        boolean pressed;
        boolean isDown;

        public Key(String keyName, boolean pressed, boolean isDown){
            this.keyName = keyName;
            this.pressed = pressed;
            this.isDown = isDown;
        }
    }

}

enum Keycodes {
    W(0),
    A(1),
    S(2),
    D(3),
    ARROW_UP(4),
    ARROW_DOWN(5),
    ARROW_RIGHT(6),
    ARROW_LEFT(7)
    ;

    private final int value;

    int getValue(){return value;}

    Keycodes(int val){
        value = val;
    }
}
