package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey = 0; // indicates how many keys player currently has

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8, 16, 25, 25);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y; // want to record default values, because we're gonna change x and y later
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        up1 = setup("boy_up_1");
        up2 = setup("boy_up_2");
        left1 = setup("boy_left_1");
        left2 = setup("boy_left_2");
        down1 = setup("boy_down_1");
        down2 = setup("boy_down_2");
        right1 = setup("boy_right_1");
        right2 = setup("boy_right_2");
    }

    public BufferedImage setup(String imageName) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if(keyH.upPressed) {
                direction = "up";
            }
            else if(keyH.downPressed) {
                direction = "down";
            }
            else if(keyH.leftPressed) {
                direction = "left";
            }
            else if(keyH.rightPressed) {
                direction = "right";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            PickUpObject(objIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false) {
                switch(direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }
            spriteCounter++;
            if(spriteCounter > 15) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void PickUpObject(int i) {
        if(i != 999) {
            // found object
            String objectName = gp.objects[i].name;
            switch(objectName) {
                case "Key":
                    gp.playSE(1);
                    hasKey++; // picked up key
                    gp.ui.showMessage("Found key!");
                    gp.objects[i] = null;
                    break;
                case "Door":
                    if(hasKey > 0) {
                        gp.playSE(3);
                        gp.objects[i] = null; // unlock door with key
                        hasKey--; // used a key
                        gp.ui.showMessage("Unlocked door!");
                    } else {
                        gp.ui.showMessage("Missing a key!");
                    }
                    break;
                case "Boots":
                    gp.playSE(2);
                    speed += 2; // increase player speed on boot pick up
                    gp.ui.showMessage("Picked up Boots!");
                    gp.objects[i] = null;
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(4); // play fanfare
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                } else {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                } else {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                } else {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                } else {
                    image = right2;
                }
                break;
        }
        // draws the image selected.
        g2.drawImage(image, screenX, screenY, null);
    }
}
