package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations;

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();

        group.addProject(this);
    }

    public void setDateInit(LocalDate dateInit) {
        this.dateInit = dateInit;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }


    public boolean isActive() {
        boolean isActive = true;

        if(LocalDate.now().isAfter(this.dateEnd)){
            isActive = false;
        } else {
            int openActivities = this.countOpenActivities();
            isActive = openActivities > 0; //si el numero de actividades abirtas es mayor a uno isActive es true.
        }
        return isActive;
    }
    public int countOpenActivities() {
        /*int count = 0;
        for (Iteration i : this.iterations){
            count += i.countOpenActivities();
        }
        return count;

         */
        return this.iterations
                .stream()
                .map(i -> i.countOpenActivities())
                .reduce(0, (a, b) -> a + b); // Investigar
    }

    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }

    public Duration getDuration() throws SabanaResearchException {

        if (this.iterations.size() <= 0)
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);

        Duration d = Duration.ZERO;
        for(Iteration i: this.iterations){
            d = d.plus(i.getDuration());
        }
        return d;
    }


}
