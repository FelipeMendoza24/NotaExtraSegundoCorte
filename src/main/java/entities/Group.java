package entities;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<Project> projects;

    public Group(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    public void addProject(Project plan) {
        this.projects.add(plan);
    }

    public int countActiveProjects() {

        return (int) this.projects.stream().map(p -> p.isActive()).filter(b -> b).count();
    }

    public int countClosedProjects() {

        return (int) this.projects.stream().map(p -> p.isClosed()).filter(b -> b).count();
    }

}
