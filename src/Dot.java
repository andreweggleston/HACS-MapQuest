import java.awt.*;

/**
 * Created by student on 9/22/17.
 */
public class Dot {

    Color  color= Color.red;
    int x,y;
    public Dot(int x2, int y2){
        x=x2;
        y=y2;
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x,y,20,20);
    }
    public void setColor(Color c){
        color=c;
    }
}
