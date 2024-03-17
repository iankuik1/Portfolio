package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Door extends SuperObject{
    GamePanel gp;
    public Door(GamePanel gp) {
        this.gp = gp;
        name = "Door";
        // collision = true;
        try{
            image = ImageIO.read(new File("res/objects/door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true; // allow collisions
    }

}
