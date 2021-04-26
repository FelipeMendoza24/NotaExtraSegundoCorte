package entities;

import java.time.Duration;
import java.util.List;

public class Student {
    private List<Activity> activitiesToDo;
    private String name;

    public String getName() {
        return name;
    }

    public Student (String name, List<Activity> activitiesToDo) {
        this.name = name;
        this.activitiesToDo =  activitiesToDo;
    }

    public Duration getDuration() throws SabanaResearchException {

        Duration d = Duration.ZERO;
        for(Activity a: activitiesToDo){
            d = d.plus(a.getDuration());
        }
        return d;
    }

}
