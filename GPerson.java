/* *****************************************************************************
 *  Name: Eli JI
 *  Date: 10-18-19
 *  Description: Graphics of a Person to be used in Josephus Graphics
 **************************************************************************** */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Font;


public class GPerson{

    private int xPos, yPos, d, num;

    public GPerson(int xPos, int yPos, int d, int num){
       this.xPos = xPos;
       this.yPos = yPos;
       this.d = d;
       this.num = num;
    }


    public void paintPerson(Graphics g){
       g.setColor(Color.BLACK);
       g.drawOval(xPos , yPos, d, d);
       drawCenteredString(g, Integer.toString(num), new Rectangle(xPos, yPos, d, d), new Font("Courier", Font.PLAIN, d/2));
   }


   //Source: https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
    private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }

}
