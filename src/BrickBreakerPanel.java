import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BrickBreakerPanel extends JPanel implements KeyListener {

    //create arraylist of objects
    ArrayList<Brick> bricks = new ArrayList<Brick>();
    ArrayList<Brick> ball = new ArrayList<Brick>();
    Brick paddle;
    Thread thread;
    Animate animate;
    int size = 25;

    BrickBreakerPanel(){
        paddle = new Brick(175, 480, 150, 25, "paddle.png");
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
        ball.add(new Brick(237, 437, 25, 25, "ball.png"));
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        //erase the screen and repaint
        super.paintComponent(g);
        for(Brick b : bricks){
            b.draw(g, this);
        }
        for(Brick b : ball){
            b.draw(g, this);
        }
        paddle.draw(g, this);
    }

    public void update(){
        for(Brick ba: ball){
            ba.x += ba.dx;
            if(ba.x > (getWidth() - size) && ba.x > 0 || ba.x < 0){
                ba.dx *= -1;
            }
            if(ba.y < 0 || ba.intersects(paddle)){
                ba.dy *= -1;
            }
            ba.y += ba.dy;

            for(Brick b : bricks){
                if(ba.intersects(b) && !b.destroyed){
                    b.destroyed = true;
                    ba.dy *= -1;
                }
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyPressed (KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            animate = new Animate(this);
            thread = new Thread(animate);
            thread.start();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0){
            paddle.x -= 15;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth() - paddle.width)){
            paddle.x += 15;
        }

    }

    public void keyReleased(KeyEvent e){

    }
}
