/**
 * Created by j remy on 9/13/17.
 * yee
 */
import javax.imageio.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
public class Main extends JPanel {
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;


    }
    public static void main(String[] args) {
        JFrame window = new JFrame("MapQuest!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 800, 800); //(x, y, w, h)
        Main panel = new Main();
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);

    }
}
