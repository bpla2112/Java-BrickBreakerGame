import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //create the frame and give it a title
        JFrame frame = new JFrame("Brick Breaker");

        BrickBreakerPanel panel = new BrickBreakerPanel();

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setSize(490, 600);

        frame.setResizable(false);
    }
}
