/**
 * Author: David Song
 * Date: 04/11/2023
 *
 * this class was written by David Song
 * [ except for some of the code which was already given by professor :) ]
 */

package simstation.prisonersdilemma;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

class Prisoner extends Agent
{
    //instance variable(s)
    private int fitness;
    private boolean partnerCheated;
    Strategy strategy;


    //constructor(s)
    public Prisoner(Strategy strategy)
    {
        this.fitness = 0;
        this.partnerCheated = false;
        this.strategy = strategy;
    }



    //accessor
    public int getFitness() {
        return fitness;
    }

    public boolean isPartnerCheated() {
        return partnerCheated;
    }

    public Strategy getS() {
        return strategy;
    }

    public boolean cooperate() { return true; }

    public Strategy getStrategy() {
        return strategy;
    }

    //mutator
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public void setPartnerCheated(boolean partnerCheated) {
        this.partnerCheated = partnerCheated;
    }

    public void setS(Strategy s) {
        this.strategy = s;
    }

    public void update()
    {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        Prisoner opponent = (Prisoner)(getWorld().getNeighbor(this, 10));
        if(opponent != null) {
            if (strategy.cooperate() && opponent.cooperate()) {
                updateFitness(3);
                opponent.updateFitness(3);
                setPartnerCheated(false);
            } else if (strategy.cooperate() && !opponent.cooperate()) {
                updateFitness(0);
                opponent.updateFitness(5);
                setPartnerCheated(true);
            } else if (!strategy.cooperate() && opponent.cooperate()) {
                updateFitness(5);
                opponent.updateFitness(0);
                setPartnerCheated(false);
            } else if (!strategy.cooperate() && !opponent.cooperate()) {
                updateFitness(1);
                opponent.updateFitness(1);
                setPartnerCheated(true);
            }
        }
    }

    public void updateFitness(int amt) {
        this.fitness += amt;
    }
}