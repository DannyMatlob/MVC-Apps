/**
 * Author: David Song
 * Date: 04/11/2023
 *
 * this class was written by David Song
 * [ except for some of the code which was already given by professor :) ]
 */

package simstation.prisonersdilemma;

import mvc.*;
import simstation.*;

import javax.swing.*;

public class PrisonerSimulation extends Simulation
{
    public void populate()
    {
        for(int i = 0; i < 10; i++) {
            System.out.println("Adding cooperating prisoners: " + i);
            addAgent(new Prisoner(new Cooperate()));
            System.out.println("Adding cheating prisoners: " + i);
            addAgent(new Prisoner(new Cheat()));
            System.out.println("Adding randomly cooperating prisoners: " + i);
            addAgent(new Prisoner(new RandomlyCooperate()));
            System.out.println("Adding tit4tat prisoners: " + i);
            addAgent(new Prisoner(new Tit4Tat()));
        }
    }

    public void stats()
    {
        double avgCooperate = 0;
        double avgCheat = 0;
        double avgRandCooperate = 0;
        double avgTit4Tat = 0;

        double cooperateCount = 0;
        double cheatCount = 0;
        double randCount = 0;
        double tit4TatCount = 0;

        for(Agent prisoner : agents)
        {
            Prisoner temp = (Prisoner)prisoner;
            String type = temp.getStrategy().getType();
            if(type.equalsIgnoreCase("Cooperate"))
            {
                avgCooperate += temp.getFitness();
                cooperateCount += 1;
            }

            else if(type.equalsIgnoreCase("Cheat"))
            {
                avgRandCooperate += temp.getFitness();
                randCount += 1;
            }

            else if(type.equalsIgnoreCase("RandCooperate"))
            {
                avgCheat += temp.getFitness();
                cheatCount += 1;
            }

            else
            {
                avgTit4Tat += temp.getFitness();
                tit4TatCount += 1;
            }
        }

        avgCooperate = avgCooperate / cooperateCount;
        avgCheat = avgCheat / cheatCount;
        avgRandCooperate = avgRandCooperate / randCount;
        avgTit4Tat = avgTit4Tat / tit4TatCount;

        JOptionPane.showMessageDialog(null,
                "cooperation avg: " + avgCooperate + "\ncheat avg: " + avgCheat + "\nrand coop avg: " + avgRandCooperate + "\ntit4tat avg: " + avgTit4Tat,
                "average",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args)
    {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }
}
