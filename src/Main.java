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
    States[] list = new States[50];
    int count=0;
    list[0]= new States(695,427);
    list[1]= new States(117,518);
    list[2]= new States(206,388);
    list[3]= new States(580,389);
    list[4]= new States(72,296);
    list[5]= new States(332,290);
    list[6]= new States(911,184);
    list[7]= new States(881,256);
    list[8]= new States(809,518);
    list[9]= new States(759,427);
    list[10]= new States(349,594);
    list[11]= new States(199,158);
    list[12]= new States(634,264);
    list[13]= new States(686,261);
    list[14]= new States(555,226);
    list[15]= new States(469,310);
    list[16]= new States(712,322);
    list[17]= new States(583,480);
    list[18]= new States(944,80);
    list[19]= new States(853,251);
    list[20]= new States(925,162);
    list[21]= new States(702,184);
    list[22]= new States(533,129);
    list[23]= new States(630,438);
    list[24]= new States(572,318);
    list[25]= new States(296,96);
    list[26]= new States(439,234);
    list[27]= new States(145,257);
    list[28]= new States(916,131);
    list[29]= new States(890,229);
    list[30]= new States(313,401);
    list[31]= new States(862,158);
    list[32]= new States(823,340);
    list[33]= new States(432,94);
    list[34]= new States(747,247);
    list[35]= new States(492,382);
    list[36]= new States(97,138);
    list[37]= new States(826,221);
    list[38]= new States(933,179);
    list[39]= new States(803,391);
    list[40]= new States(436,160);
    list[41]= new States(688,363);
    list[42]= new States(453,470);
    list[43]= new States(227,276);
    list[44]= new States(896,127);
    list[45]= new States(828,297);
    list[46]= new States( 119,59);
    list[47]= new States( 786,283);
    list[48]= new States( 612,159);
    list[49]= new States( 311,191);

    public Main(){

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("list["+count+"]"+"= new States("+mouseEvent.getX()+","+mouseEvent.getY()+")");
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
        for (int i = 0; i <list.length ; i++) {
            if(list[i]!=null){
                g2.drawRect(25,25,list[i].x,list[i].y);
            }
        }


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