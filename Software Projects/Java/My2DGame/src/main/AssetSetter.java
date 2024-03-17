package main;

import object.Chest;
import object.Door;
import object.Key;
import object.OBJ_BOOTS;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.objects[0] = new Key(gp);
        gp.objects[0].worldX = 23 * gp.tileSize;
        gp.objects[0].worldY = 7 * gp.tileSize;

        gp.objects[1] = new Key(gp);
        gp.objects[1].worldX = 23 * gp.tileSize;
        gp.objects[1].worldY = 40 * gp.tileSize;

        gp.objects[2] = new Key(gp);
        gp.objects[2].worldX = 37 * gp.tileSize;
        gp.objects[2].worldY = 7 * gp.tileSize;

        gp.objects[3] = new Door(gp);
        gp.objects[3].worldX = 10 * gp.tileSize;
        gp.objects[3].worldY = 11 * gp.tileSize;

        gp.objects[4] = new Door(gp);
        gp.objects[4].worldX = 8 * gp.tileSize;
        gp.objects[4].worldY = 28 * gp.tileSize;

        gp.objects[5] = new Door(gp);
        gp.objects[5].worldX = 12 * gp.tileSize;
        gp.objects[5].worldY = 22 * gp.tileSize;

        gp.objects[6] = new Chest(gp);
        gp.objects[6].worldX = 10 * gp.tileSize;
        gp.objects[6].worldY = 7 * gp.tileSize;

        gp.objects[7] = new OBJ_BOOTS(gp);
        gp.objects[7].worldX = 37 * gp.tileSize;
        gp.objects[7].worldY = 42 * gp.tileSize;
    }
}
