import java.awt.*;

public class Brick extends Rectangle{
    Image picture;
    int dx = 3;
    int dy = -3;
    boolean destroyed = false;

    Brick(int a, int b, int w, int h, String s){
        x = a;
        y = b;
        width = w;
        height = h;
        picture = Toolkit.getDefaultToolkit().getImage(s);
    }

    public void draw(Graphics g, Component c){
        if(!destroyed){
            g.drawImage(picture, x, y, width, height, c);
        }

    }
}
