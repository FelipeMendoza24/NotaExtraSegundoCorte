package entities;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;



public class ExecutiveSynthesizer implements ISynthesizer{

    public List<Iteration> iterations;
    public ArrayList<String> summary;

    public ExecutiveSynthesizer(List<Iteration> iterations) {
        this.iterations = iterations;
    }

    @Override
    public List <String> synthezise() throws SabanaResearchException{

        String objective = null;

        summary = new ArrayList<>();

        if(this.iterations == null){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);
        }
        Duration d = Duration.ZERO;
        for (Iteration i : this.iterations){
            d=i.getDuration();
            objective = i.getGoal();
            summary.add("Duración:"+ d +"Objetivo: "+ objective);
        }
        return summary;
    }
}
