package controller;

import model.LevelFactory;
import view.GUI;

public class Time {
    long lastLoopTime = System.nanoTime();
    int TARGET_FPS;
    long OPTIMAL_TIME;
    long lastFpsTime;
    long fps;
    boolean gameRunning = true;
    GUI gui;
    LevelFactory lv;

    // RunGame R = new
    Time() {
        lv = new LevelFactory();
        gui = GUI.getInstance();
        gui.run();
        lv.setStartTime(System.nanoTime());

    }

    // to do , finish and show the state of winner .....
    public void pause() {
    }

    public void cont() {
    }

    public void reset() {
    }

    public void start() {
        
        while (gameRunning) {
            TARGET_FPS = lv.getFPS();
            OPTIMAL_TIME = 1000000000 / TARGET_FPS ;
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000) {
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            // run();
            gui.up();
            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in
            // ns.
            try {
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME)
                        / 1000000);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        Time time = new Time();

        time.start();

    }
}
