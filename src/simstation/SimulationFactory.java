package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class SimulationFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return null;
    }

    @Override
    public View makeView(Model m) {
        return new SimulationView((Simulation) m);
    }

    @Override
    public String getTitle() {
        return "Simstation";
    }

    @Override
    public String[] getHelp() {
        return new String[] { "Start: begins the simulation","Suspend: pauses the simulation", "Resume: resumes the simulation", "Stop: halts the simulation"};
    }

    @Override
    public String about() {
        return "null";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start","Suspend","Resume","Stop","Stats"};
    }

    @Override
    public Command makeEditCommand(Model m, String name, Object source) {
        return new SimulationCommand(m, name);
    }
}
