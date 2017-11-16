import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BrickBreakerPanel extends JPanel {

    //create arraylist of objects
    ArrayList<Brick> bricks = new ArrayList<Brick>();

    BrickBreakerPanel(){
        for(int i = 0; i < 8; i++){
            bricks.add(new Brick((i * 60 + 2), 0, 60, 25, "blue.png"));
        }
        for(int i = 0; i < 8; i++){
            bricks.add(new Brick((i * 60 + 2), 25, 60, 25, "red.png"));
        }
        for(int i = 0; i < 8; i++){
            bricks.add(new Brick((i * 60 + 2), 50, 60, 25, "green.png"));
        }
        for(int i = 0; i < 8; i++){
            bricks.add(new Brick((i * 60 + 2), 75, 60, 25, "yellow.png"));
        }
    }

    public void paintComponent(Graphics g){
        for(Brick b : bricks){
            b.draw(g, this);
        }
    }
}
