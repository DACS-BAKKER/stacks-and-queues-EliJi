/* *****************************************************************************
 *  Name: Eli JI
 *  Date: 10-18-19
 *  Description: Graphics of a Executioner to be used in Josephus Graphics
 **************************************************************************** */


import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;


public class GExecutioner {
    private Timer animator;
    private ImageIcon imageArray[];
    private int delay = 100, totalFrames = 7, currentFrame = 1;
    private int xPos, yPos, d;


    public GExecutioner(int d) {
        this.d = d;
        this.xPos = 0;
        this.yPos = 0;
        imageArray = new ImageIcon[totalFrames];
        for(int i = 0; i < imageArray.length; i ++) {
            ImageIcon imageIcon = new ImageIcon("frame" + (i + 1) + ".png");
            Image image = imageIcon.getImage();
            //scales image to width, height
            image = image.getScaledInstance(d, d,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageArray[i] =  imageIcon;
        }
    }

    public void paintExecutioner(Graphics g) {
        if(currentFrame == totalFrames + 1){
            currentFrame = 1;
        }
        g.drawImage(imageArray[currentFrame - 1].getImage(), xPos, yPos, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width,
                                       int height) {
                return false;
            }
        });
        currentFrame ++;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
