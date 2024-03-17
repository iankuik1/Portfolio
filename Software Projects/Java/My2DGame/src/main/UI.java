package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

/**
 * Handles Onscreen UI
 */
public class UI {
    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage keyImage;
    int messageCounter = 0;
    public boolean messageOn = false;
    public String message = "";
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40); // instantiate before game loop starts
        arial_80B = new Font("Arial", Font.BOLD, 80);
        Key key = new Key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        if(gameFinished) {
            String text;
            int textLength;
            int x, y;
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            text = ("You found the treasure!");
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // get the width of text
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize  * 3); // offset y to not overwrite character
            g2.drawString(text, x, y);

            text = ("Time taken: " + dFormat.format(playTime) + "s");
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // get the width of text
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize  * 3); // offset y to not overwrite character
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.yellow);
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // get the width of text
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize); // offset y to not overwrite character
            g2.drawString(text, x, y);

            gp.gameThread = null;


        } else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            // TIME
            playTime += (double) 1/60;
            g2.drawString("Time:" + dFormat.format(playTime), gp.tileSize*11, 65);
            // MESSAGES
            if(messageOn) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
                messageCounter++;
                if(messageCounter == 40) {
                    messageOn = false;
                    messageCounter = 0;
                }
            }
        }
    }
}
