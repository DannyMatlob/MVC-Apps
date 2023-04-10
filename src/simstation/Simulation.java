package simstation;

import mvc.Model;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Model {
    List<Agent> agents = new ArrayList<>();
    int clock = 0;

    public void start() {
        for (Agent a : agents) {
            a.start();
        }
    }
    public void suspend() {
        for (Agent a : agents) {
            a.suspend();
        }
    }
    public void resume() {
        for (Agent a : agents) {
            a.resume();
        }
    }
    public void stop() {
        for (Agent a : agents) {
            a.stop();
        }
    }
    public Agent getNeighbor(Agent a, double radius) {
        return null;
    }
    public void populate() {}

    public void addAgent(Agent a) {

    }
}
