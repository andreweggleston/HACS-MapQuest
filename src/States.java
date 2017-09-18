/**
 * Created by student on 9/15/17.
 */
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class States {
    int x,y;
    String state;
    BufferedImage img =null;
    public States( int x2, int y2){
        x=x2;
        y=y2;

    }
    public void draw(){
        try {
            img = ImageIO.read(new File(state+".png"));

        } catch (IOException e) {
        }
        Graphics g = img.getGraphics();
        g.drawImage(img,x,y,null);
    }

}
