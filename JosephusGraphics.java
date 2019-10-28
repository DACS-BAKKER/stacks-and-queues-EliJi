/* *****************************************************************************
 *  Name: Eli JI
 *  Date: 10-18-19
 *  Description: Josephus Problem Graphics
 **************************************************************************** */

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

public class JosephusGraphics{

    private static int appWidth = 600;
    private static int appHeight = 600;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Josephus Problem Graphics");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel(appWidth, appHeight, 20,2));
        f.setSize(appWidth,appHeight);
        f.setVisible(true);
    }
}

class MyPanel extends JPanel implements ActionListener {

    //application width
    private static int appWidth;
    //application height
    private static int appHeight;
    //number of people
    private static int people;
    //number of people to skip
    private static int skip;
    //animation delay
    private int delay = 100;
    //animation timer
    private Timer animator;
    private static int executionerDiameter;

    private GExecutioner executioner;
    private Queue<Integer> Q;

    public MyPanel(int appWidth, int appHeight, int people, int skip) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.WHITE);
        this.appWidth = appWidth;
        this.appHeight = appHeight;
        this.people = people;
        this.skip = skip;
        this.executionerDiameter = 130 + 60 / people;
        this.executioner = new GExecutioner(executionerDiameter);
        this.Q =  new Queue<Integer>();
        animator = new Timer(delay, this);
        animator.start();
        for(int i = 0; i < people; i++){
            Q.enqueue(i);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawString("This is my custom Panel!",10,20);
        drawExecutioner(g, 0);
        drawPeople(g);
    }

    private void drawPeople(Graphics g) {
        double angle = 360 / people;
        int diameter = 30 + 60/people;
        for (int i = 0; i < people; i++) {
            double posAngle = angle * i;
            int x = (int) (appWidth/2 + (appWidth * 0.25 * Math.cos(Math.toRadians(posAngle)))) - diameter / 2;
            int y = (int) (appHeight / 2 + (appHeight * 0.25 * -Math.sin(Math.toRadians(posAngle)))) - diameter;
            GPerson p = new GPerson(x, y, diameter, i);
            p.paintPerson(g);
        }
    }

    private void drawExecutioner(Graphics g, double posAngle){
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
        //draw shape/image (will be rotated)
        //int x = (int) (appWidth/2 + (appWidth * 0.3 + executionerDiameter/2) * Math.cos(Math.toRadians(posAngle))) - executionerDiameter / 2;
        //int y = (int) (appHeight/2 + (appHeight * 0.3 * -Math.sin(Math.toRadians(posAngle))) - (executionerDiameter * 0.7));
        int x = 200;
        int y = 200 - (int)(0.8 * executionerDiameter);
        executioner.setxPos(x);
        executioner.setyPos(y);
        g2d.rotate(Math.toRadians(-10), x, y + (int)(0.8 * executionerDiameter));
        executioner.paintExecutioner(g);
        g2d.setTransform(old);
        g.drawString("Test", x, y + (int)(0.8 * executionerDiameter));
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        //repaint(new Rectangle(executioner.getxPos(),executioner.getyPos(), executionerDiameter, executionerDiameter));
    }

}
