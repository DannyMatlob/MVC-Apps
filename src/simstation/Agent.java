package simstation;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {
    String name;
    public Heading heading;
    int xc;
    int yc;
    boolean suspended = false;
    boolean stopped = false;
    Thread myThread;

    public void run() {}
    public void start() {}
    public void suspend() {}
    public void resume() {}
    public void stop() {}
    public void update() {}
    public void move(int steps) {}
}
