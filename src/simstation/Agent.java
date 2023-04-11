package simstation;

import mvc.Utilities;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {
    String name;
    public Heading heading;
    int xc = Utilities.rng.nextInt(500);
    int yc = Utilities.rng.nextInt(500);
    boolean suspended = false;
    boolean stopped = false;

    Simulation world;
    Thread myThread;

    public void setWorld(Simulation s) {
        world = s;
    }
    public int getX () {
        return xc;
    }
    public int getY () {
        return yc;
    }
    public void run() {
        myThread = Thread.currentThread();
        try {
            while (!stopped) {
                update();
                Thread.sleep(20);
                checkSuspended();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private synchronized void checkSuspended() {
        try {
            while (!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void start() {
        run();
    }
    public synchronized void suspend() {
        suspended = true;
    }
    public synchronized void resume() {
        suspended = false;
    }
    public synchronized void stop() {
        stopped = true;
    }
    public synchronized void update() {}
    public synchronized void move(int steps) {
        switch (heading) {
            case NORTH: {
                yc-=steps;
                break;
            }
            case SOUTH: {
                yc+=steps;
                break;
            }
            case EAST: {
                xc+=steps;
                break;
            }
            case WEST: {
                xc-=steps;
                break;
            }
        }
    }
}
