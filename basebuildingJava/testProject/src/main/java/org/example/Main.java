package org.example;

import org.example.gameobjects.Player;
import org.example.common.Handler;
import org.example.constant.ConstantsMain;
import org.example.display.Window;
import org.example.gameobjects.homebase.HomeBase;
import org.example.gameobjects.path.Path;
import org.example.gameobjects.resources.IronResource;
import org.example.gameobjects.resources.WaterResource;
import org.example.gameobjects.resources.WoodResource;
import org.example.input.KeyInputHandler;
import org.example.ui.HUD;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {
    private Thread thread;
    private boolean isRunning = false;

    //handler
    private Handler handler;

    //input
    private KeyInputHandler keyInputHandler;

    public Main(){
        new Window(ConstantsMain.WIDTH, ConstantsMain.HEIGHT, this);
        init();
    }
    public static void main(String[] args) {
        new Main();
    }

    private void init(){
        this.requestFocus();

        if(this.thread == null){
            this.thread = new Thread(this, "Additional_Thread_1");
        }

        if(this.handler == null){
            this.handler = new Handler();
        }

        //key input handler
        if(this.keyInputHandler == null){
            this.keyInputHandler = new KeyInputHandler();
        }
        this.addKeyListener(this.keyInputHandler);

        //generating map

        //adding home base to protect
        this.handler.addGameObjectToList(new HomeBase(0, 500));

        //adding the path
        this.handler.addGameObjectToList(new Path(0, 100));
        this.handler.addGameObjectToList(new Path(50, 100));
        this.handler.addGameObjectToList(new Path(100, 100));
        this.handler.addGameObjectToList(new Path(150, 100));
        this.handler.addGameObjectToList(new Path(150, 150));
        this.handler.addGameObjectToList(new Path(150, 200));
        this.handler.addGameObjectToList(new Path(150, 250));

        this.handler.addGameObjectToList(new Path(200, 250));
        this.handler.addGameObjectToList(new Path(250, 250));
        this.handler.addGameObjectToList(new Path(300, 250));
        this.handler.addGameObjectToList(new Path(350, 250));
        this.handler.addGameObjectToList(new Path(350, 200));
        this.handler.addGameObjectToList(new Path(350, 150));
        this.handler.addGameObjectToList(new Path(350, 100));
        this.handler.addGameObjectToList(new Path(400, 100));
        this.handler.addGameObjectToList(new Path(450, 100));
        this.handler.addGameObjectToList(new Path(500, 100));
        this.handler.addGameObjectToList(new Path(500, 150));
        this.handler.addGameObjectToList(new Path(500, 200));
        this.handler.addGameObjectToList(new Path(500, 250));
        this.handler.addGameObjectToList(new Path(500, 300));
        this.handler.addGameObjectToList(new Path(500, 350));
        this.handler.addGameObjectToList(new Path(500, 400));
        this.handler.addGameObjectToList(new Path(500, 450));
        this.handler.addGameObjectToList(new Path(500, 500));
        this.handler.addGameObjectToList(new Path(500, 550));
        this.handler.addGameObjectToList(new Path(500, 600));
        this.handler.addGameObjectToList(new Path(500, 650));
        this.handler.addGameObjectToList(new Path(500, 700));


        this.handler.addGameObjectToList(new Path(450, 700));
        this.handler.addGameObjectToList(new Path(400, 700));
        this.handler.addGameObjectToList(new Path(350, 700));
        this.handler.addGameObjectToList(new Path(300, 700));
        this.handler.addGameObjectToList(new Path(250, 700));
        this.handler.addGameObjectToList(new Path(200, 700));
        this.handler.addGameObjectToList(new Path(150, 700));
        this.handler.addGameObjectToList(new Path(100, 700));
        this.handler.addGameObjectToList(new Path(50, 700));
        this.handler.addGameObjectToList(new Path(0, 700));
        this.handler.addGameObjectToList(new Path(0, 650));
        //this.handler.addGameObjectToList(new Path(0, 600));
        //this.handler.addGameObjectToList(new Path(0, 550));


        //adding water resource
        this.handler.addGameObjectToList(new WaterResource(700, 300));

        //adding wood resource
        this.handler.addGameObjectToList(new WoodResource(700, 500));

        //adding iron resource
        this.handler.addGameObjectToList(new IronResource(700, 700));

        //adding UI Components
        //adding HUD(Main)
        this.handler.addGameObjectToList(new HUD(15, 15));


        //adding player
        this.handler.addGameObjectToList(new Player(100, 150, this.keyInputHandler, this.handler));



        start();
    }

    private synchronized void start(){
        if(this.isRunning){
            return;
        }
        if(this.thread != null){
            this.thread.start();
        }
        this.isRunning = true;
    }

    private synchronized void stop(){
        if(!this.isRunning){
            return;
        }
        try{
            this.thread.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        this.isRunning = false;
    }

    @Override
    public void run() {
        mainLoop();
    }

//    private void mainLoop(){
//        final int TARGET_FPS = 60;
//        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
//
//        long lastLoopTime = System.nanoTime();
//        long lastFpsTime = 0;
//
//        while (this.isRunning) {
//            long now = System.nanoTime();
//            long updateLength = now - lastLoopTime;
//            lastLoopTime = now;
//
//            double delta = updateLength / ((double) OPTIMAL_TIME);
//
//            lastFpsTime += updateLength;
//            if (lastFpsTime >= 1000000000) {
//                lastFpsTime = 0;
//            }
//
//            // Update game logic based on delta
//            tick(delta);
//
//            // Repaint or render the game
//            render();
//
//            try {
//                // Sleep to maintain frame rate
//                long gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
//                Thread.sleep(gameTime);
//            } catch (Exception e) {
//                // Handle exceptions
//                this.isRunning = false;
//            }
//        }
//        stop();
//    }

    private void mainLoop(){
        try{
            long lastTime = System.nanoTime();

            double amountOfTicks = 60;
            double ns = 1000000000 / amountOfTicks;

            double delta = 0;
            long timer = System.currentTimeMillis();

            int frames = 0;

            while(isRunning){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;

                while(delta >= 1){
                    //Calls tick method every frame
                    tick(00);
                    delta--;
                }

                //Calls render method every loop
                render();
                frames++;

                if((System.currentTimeMillis() - timer) > 1000){
                    timer += 1000;
                    frames = 0;
                }

            }
            stop();

        }catch (Exception ex){
            throw ex;
        }

    }

    private void tick(double delta){
        if(this.handler != null) {
            this.handler.tick();
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(03);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        //g.setColor(Color.BLACK);
        g.fillRect(0, 0, ConstantsMain.WIDTH, ConstantsMain.HEIGHT);

        //additional render calls goes here
        if(this.handler != null) {
            this.handler.render(g);
        }



        bs.show();
        g.dispose();
    }
}