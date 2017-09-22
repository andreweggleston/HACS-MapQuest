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
    public States(String state2, int x2, int y2){
        x=x2;
        y=y2;
        state=state2;

    }
    public void draw(){
        try {
            img = ImageIO.read(new File(state+".png"));

        } catch (IOException e) {
        }
        Graphics g = img.getGraphics();
        g.drawImage(img,x,y,null);
    }
    public boolean check(int x2, int y2){
        if(Math.abs(x-x2)>20){
            return false;
        }
        if(Math.abs(y-y2)>20){
            return false;
        }
        return true;


    }

    public String getState() {
        return state;
    }

}
