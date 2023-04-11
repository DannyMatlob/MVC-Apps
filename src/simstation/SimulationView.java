package simstation;

import mvc.*;

import java.awt.*;
import java.util.Iterator;

public class SimulationView extends View {
    public SimulationView(Simulation s) {
        super(s);
    }

    public void paintComponent(Graphics gc) {
        Simulation s = (Simulation) model;
        super.paintComponent(gc);
        Color oldColor = gc.getColor();

        gc.setColor(new Color(236, 14, 14));
        Iterator<Agent> agentIterator = s.iterator();
        while (agentIterator.hasNext()) {
            Agent a = agentIterator.next();
            int x = a.getX();
            int y = a.getY();
            gc.fillOval(x, y, 15, 15);
        }
        gc.setColor(oldColor);
    }
}
