//70% of this class was written by Danny Matlob
//30% of this class was written by Hasnain Mucklai
package minefield;

import mvc.*;

public class MinefieldFactory implements AppFactory{

    public Model makeModel() {
        return new Minefield(20,15);
    }

    public View makeView(Model m) {
        return new MinefieldView((Minefield) m);
    }

    public String getTitle() {
        return "Minefield Project Team 4";
    }

    public String[] getHelp() {
        return new String[] { "Click on a button to move in that direction.","Alternatively, use Arrow Keys to move on MineField" };
    }

    public String about() {
        return "CS151 Minefield Project Team 4";
    }

    public String[] getEditCommands() {
        return new String[] { "North", "South", "East", "West", "NorthWest", "NorthEast", "SouthWest", "SouthEast" };
    }

    public Command makeEditCommand(Model model, String name, Object source) {
        if (name.equals("N") || name.equals("North")) {
            return new MoveCommand(model, Heading.NORTH);
        }
        if (name.equals("S") || name.equals("South")) {
            return new MoveCommand(model, Heading.SOUTH);
        }
        if (name.equals("E") || name.equals("East")) {
            return new MoveCommand(model, Heading.EAST);
        }
        if (name.equals("W") || name.equals("West")) {
            return new MoveCommand(model, Heading.WEST);
        }
        if (name.equals("NW") || name.equals("NorthWest")) {
            return new MoveCommand(model, Heading.NORTHWEST);
        }
        if (name.equals("NE") || name.equals("NorthEast")) {
            return new MoveCommand(model, Heading.NORTHEAST);
        }
        if (name.equals("SW") || name.equals("SouthWest")) {
            return new MoveCommand(model, Heading.SOUTHWEST);
        }
        if (name.equals("SE") || name.equals("SouthEast")) {
            return new MoveCommand(model, Heading.SOUTHEAST);
        }
        System.out.println("Invalid Command");
        return null;
    }
}