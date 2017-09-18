/**
 * Created by j remy on 9/13/17.
 * yee
 */
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.IOException;

public class Main extends JPanel {
    public Main(){
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                System.out.println("yeee");
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                //called when mouse leaves the panel.

            }
        });

    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        BufferedImage img= null;

        try {
            img = ImageIO.read(new File("Images/Map.png"));
        } catch (IOException e) {

        }
        g2.drawImage(img,0,0,null);


    }
    public static void main(String[] args) {
        JFrame window = new JFrame("MapQuest!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1000, 800); //(x, y, w, h)
        Main panel = new Main();
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);

    }
}