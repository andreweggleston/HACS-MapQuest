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
import java.lang.reflect.Array;

public class Main extends JPanel {
    States[] list= new States[50];
    int count=0;
    list[0]= new States( x,695,427)
    list[1]= new States( x,117,518)
    list[2]= new States( x,206,388)
    list[3]= new States( x,580,389)
    list[4]= new States( x,72,296)
    list[5]= new States( x,332,290)
    list[6]= new States( x,911,184)
    list[7]= new States( x,881,256)
    list[8]= new States( x,809,518)
    list[9]= new States( x,759,427)
    list[10]= new States( x,349,594)
    list[11]= new States( x,199,158)
    list[12]= new States( x,634,264)
    list[13]= new States( x,686,261)
    list[14]= new States( x,555,226)
    list[15]= new States( x,469,310)
    list[16]= new States( x,712,322)
    list[17]= new States( x,583,480)
    list[18]= new States( x,944,80)
    list[19]= new States( x,853,251)
    list[20]= new States( x,925,162)
    list[21]= new States( x,702,184)
    list[22]= new States( x,533,129)
    list[23]= new States( x,630,438)
    list[24]= new States( x,572,318)
    list[25]= new States( x,296,96)
    list[26]= new States( x,439,234)
    list[27]= new States( x,145,257)
    list[28]= new States( x,916,131)
    list[29]= new States( x,890,229)
    list[30]= new States( x,313,401)
    list[31]= new States( x,862,158)
    list[32]= new States( x,823,340)
    list[33]= new States( x,432,94)
    list[34]= new States( x,747,247)
    list[35]= new States( x,492,382)
    list[36]= new States( x,97,138)
    list[37]= new States( x,826,221)
    list[38]= new States( x,933,179)
    list[39]= new States( x,803,391)
    list[40]= new States( x,436,160)
    list[41]= new States( x,688,363)
    list[42]= new States( x,453,470)
    list[43]= new States( x,227,276)
    list[44]= new States( x,896,127)
    list[45]= new States( x,828,297)
    list[46]= new States( x,119,59)
    list[47]= new States( x,786,283)
    list[48]= new States( x,612,159)
    list[49]= new States( x,311,191)

    public Main(){

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("list["+count+"]"+"= new States( x,"+mouseEvent.getX()+","+mouseEvent.getY()+")");
                count++;
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

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