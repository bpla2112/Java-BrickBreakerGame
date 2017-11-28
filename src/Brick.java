import java.awt.*;

public class Brick extends Rectangle{
    Image picture;
    int dx = 3;
    int dy = -3;
    Rectangle left, right;
    boolean destroyed = false;
    boolean powerup = false;

    Brick(int a, int b, int w, int h, String s){
        x = a;
        y = b;
        width = w;
        height = h;
        left = new Rectangle(a-1, b, 1, h);
        right = new Rectangle(a+w+1, b, 1, h);
        picture = Toolkit.getDefaultToolkit().getImage(s);
    }

    public void draw(Graphics g, Component c){
        if(!destroyed){
            g.drawImage(picture, x, y, width, height, c);
        }

    }
}
