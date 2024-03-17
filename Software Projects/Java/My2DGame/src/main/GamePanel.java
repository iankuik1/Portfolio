package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SET SCREEN SETTINGS AND TILE SIZE
    public final int originalTileSize = 16; // 16x16 tile
    public final int scale = 3; // scale up characters for display resolution
    // TILE SIZES
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12; // 4:3 aspect ratio
    public final int screenWidth = tileSize * maxScreenCol; // 718 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // SET FPS
    int FPS = 60;

    // INITIALISE SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread; // keeps your program running till you stop it

    // INITIALIZE ENTITIES AND OBJECTS
    public Player player = new Player(this, keyH);
    public SuperObject[] objects = new SuperObject[10]; // can display up to 10 objects at once

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {
        assetSetter.setObject();
        playMusic(0); // play theme song on launch
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        // create the game loop, the core of our game
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/ drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                // 1 UPDATE: update information such as character positions
                update();
                // 2 DRAW: draw the screen with the updated information
                repaint();
                delta--;
                drawCount++;
            }

            // display FPS
            if(timer >= 1000000000) {
                //System.out.println(drawCount + "FPS");
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // DEBUG
        long drawStart = 0;
        if(keyH.checkDrawTime) {
            drawStart = System.nanoTime(); // check time
        }


        tileM.draw(g2);

        // draw objects
        for(SuperObject o: objects) {
            if(o != null) {
                o.draw(g2, this);
            }
        }

        player.draw(g2);

        // ui
        ui.draw(g2);

        // DEBUG
        if(keyH.checkDrawTime) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }
        g2.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop(); // sets audio file and loops it
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSE(int i) {
        se.setFile(i);
        se.play(); // play sound once
    }
}
