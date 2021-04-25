package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Iteration {

    private String goal;
    private Project project;
    private List<Activity> activities;

    public Iteration(String goal, Project project) {
        this.goal = goal;
        this.project = project;
        this.activities = new ArrayList<>();

        project.addIteration(this);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public int countOpenActivities() {
        /** int count = 0;
         *   for(Activity a: this.activities){
         *       if(a.isActive()){
         *           count++;
         *       }
         *   }
         *    return count;
         * lo mismo de abajo pero abajo esta resumido
         */
        /**
         * for(int i = 0; i < this.activities.size(); i++){
         *             if(this.activities.get(i).isActive()){
         *                 count++;
         * es lo mismo que arriba
         */
        return (int) this.activities.stream().map(a-> a.isActive()).filter(b -> b).count();
        // se cambian a lista de buleanos y filtra los que son true

    }

    public Duration getDuration() throws SabanaResearchException {

        if (this.activities.size() <= 0)
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_ITERATION);

        Duration d = Duration.ZERO;
        for (Activity a: this.activities){
            d = d.plus(a.getDuration());
        }
        return d;
    }
}
