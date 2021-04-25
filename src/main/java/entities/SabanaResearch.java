package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SabanaResearch {

    private List<Group> groups;
    private List<Summary> summaries;

    public SabanaResearch(List<Group> groups) {
        this.groups = groups;
        this.summaries = new ArrayList<>();
    }

    public int countOfGroups() {
        return this.groups.size();
    }

    public int countOfSummaries() {
        return this.summaries.size();
    }

    /**
     * Create a summary entry in the current date.
     * - Calculate the count of active projects.
     *
     * @return The new Summary entry.
     */
    public Summary createSummaryEntry() {
        //int activeProjects = this.groups.stream().map( g-> g.countActiveProjects()). reduce(0,(a,b) -> a+b);
        int activeProjects = 0;
        for (Group g: this.groups){
            activeProjects += g.countActiveProjects();
        }

        Summary summary = new Summary(activeProjects, java.time.LocalDate.now());
        this.summaries.add(summary);

        return summary;
    }
    public int countClosedProjects() {

        return this.groups
                .stream()
                .map(i -> i.countClosedProjects())
                .reduce(0, (a, b) -> a + b);
    }
}
