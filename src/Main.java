/**
 * Created by j remy on 9/13/17.
 * yeet
 */

import javax.imageio.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.ArrayList;

public class Main extends JPanel {
    private ArrayList<States> list = new ArrayList<States>();
    private ArrayList<States> used = new ArrayList<States>();

    private ArrayList<Dot> cirs = new ArrayList<Dot>();
    private ArrayList<Dot> usedCirs = new ArrayList<Dot>();


    private int count = 0;
    private int spot;
    private int level=0;
    private States answer= null;
    private States Uranswer= null;
    private int right=0;
    private int wrong=0;

    private Timer timer;
    private int c;
    private int z;


    public void makelist(ArrayList<States> list){
        list.add(new States("Alabama", 695, 427));
        list.add(new States("Alaska", 117, 518));
        list.add(new States("Arizona", 206, 388));
        list.add(new States("Arkansas", 580, 389));
        list.add(new States("California", 72, 296));
        list.add(new States("Colorado", 332, 290));
        list.add(new States("Connecticut", 911, 184));
        list.add(new States("Delaware", 906, 265));
        list.add(new States("Florida", 809, 518));
        list.add(new States("Georgia", 759, 427));
        list.add(new States("Hawaii", 349, 594));
        list.add(new States("Idaho", 199, 158));
        list.add(new States("Illinois", 634, 264));
        list.add(new States("Indiana", 686, 261));
        list.add(new States("Iowa", 555, 226));
        list.add(new States("Kansas", 469, 310));
        list.add(new States("Kentucky", 712, 322));
        list.add(new States("Louisiana", 583, 480));
        list.add(new States("Maine", 944, 80));
        list.add(new States("Maryland", 853, 251));
        list.add(new States("Massachusetts", 925, 162));
        list.add(new States("Michigan", 702, 184));
        list.add(new States("Minnesota", 533, 129));
        list.add(new States("Mississippi", 630, 438));
        list.add(new States("Missouri", 572, 318));
        list.add(new States("Montana", 296, 96));
        list.add(new States("Nebraska", 439, 234));
        list.add(new States("Nevada", 145, 257));
        list.add(new States("New Hampshire", 916, 131));
        list.add(new States("New Jersey", 890, 229));
        list.add(new States("New Mexico", 313, 401));
        list.add(new States("New York", 862, 158));
        list.add(new States("North Carolina", 823, 340));
        list.add(new States("North Dakota", 432, 94));
        list.add(new States("Ohio", 747, 247));
        list.add(new States("Oklahoma", 492, 382));
        list.add(new States("Oregon", 97, 138));
        list.add(new States("Pennsylvania", 826, 221));
        list.add(new States("Rhode Island", 948, 195));
        list.add(new States("South Carolina", 803, 391));
        list.add(new States("South Dakota", 436, 160));
        list.add(new States("Tennessee", 688, 363));
        list.add(new States("Texas", 453, 470));
        list.add(new States("Utah", 227, 276));
        list.add(new States("Vermont", 896, 127));
        list.add(new States("Virginia", 828, 297));
        list.add(new States("Washington", 119, 59));
        list.add(new States("West Virginia", 786, 283));
        list.add(new States("Wisconsin", 612, 159));
        list.add(new States("Wyoming", 311, 191));
    }

    public Main() {
        makelist(list);
        for (int i = 0; i <list.size() ; i++) {
            cirs.add(new Dot(list.get(i).x,list.get(i).y));
        }
        answer=list.get((int)(Math.random()*list.size()));


        timer = new Timer(100, new ActionListener() {//seconds
            @Override
            public void actionPerformed(ActionEvent e) {
                z++;
                if(z%10==0){
                    z=0;
                    c++;
                }
                if(list.size()==0){
                    level++;
                    z=0;
                    makelist(list);
                    for (int i = 0; i <list.size() ; i++) {
                        cirs.add(new Dot(list.get(i).x,list.get(i).y));
                    }
                    for (int i = 0; i <used.size() ; i++) {
                        used.remove(i);
                        usedCirs.remove(i);
                    }


                }
            }


        });

        timer.start();



        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getX()+" "+mouseEvent.getY());
                if(level==0) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).check(mouseEvent.getX(), mouseEvent.getY())) {
                            Uranswer = list.get(i);
                            spot = i;

                        }
                    }
                    if (spot > 0) {
                        if (!Uranswer.equals(answer)) {
                            wrong++;
                        }

                    }

                    if (spot > 0) {
                        if (Uranswer.equals(answer)) {
                            cirs.get(spot).setColor(Color.green);
                            right++;
                            used.add(list.get(spot));
                            list.remove(spot);
                            usedCirs.add(cirs.get(spot));
                            cirs.remove(spot);
                            if (list.size() != 0) {
                                answer = list.get((int) (Math.random() * list.size()));
                            }

                        }
                    }
                    spot = -1;
                    //if(Math.abs(mouseEvent.getX()-800)<100&&Math.abs(mouseEvent.getY()))
                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
               // c++;
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

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        BufferedImage img = null;
        BufferedImage clip = null;



        try {
            img = ImageIO.read(new File("Images/Map.png"));
            clip = ImageIO.read(new File("Images/clip.png"));

        } catch (IOException e) {

        }
        if(level==0) {
            g2.drawImage(img, 0, 0, null);
            g2.drawImage(clip, 865, 460, null);
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(948, 195, 933, 180);
            g2.drawLine(906, 265, 882, 260);
            g2.drawString(answer.getState(), 900, 600);
            Font font = new Font("Times New Roman", Font.BOLD, 30);
            g2.setFont(font);
            g2.drawString(right + " Correct Answers", 400, 700);
            g2.drawString(wrong + " Wrong Answer", 400, 740);
            for (int i = 0; i < list.size(); i++) {
                cirs.get(i).draw(g2);
            }
            for (int i = 0; i < usedCirs.size(); i++) {
                usedCirs.get(i).draw(g2);
            }

            //g2.drawString(c+"",0,750);
            Font currentFont = g.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 2.4F);
            g.setFont(newFont);
            g2.setColor(Color.red);
            g2.drawString(c + "", 55, 750);
            if (c < 10) {
                g2.drawString("." + z + "", 87, 750);
            } else if (c < 100) {
                g2.drawString("." + z, 127, 750);

            } else
                g2.drawString("." + z, 157, 750);

            Font small= new Font("Times New Roman", Font.BOLD,22);
            g2.setFont(small);
            g2.drawString("End Game", 750,100);
        }
        repaint();

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