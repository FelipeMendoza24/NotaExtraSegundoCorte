import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SabanaResearchTest {

    private SabanaResearch sabanaResearch;
    private List<Group> groups;
    private List<Project> projects;
    private List<Iteration> iterations;

    public SabanaResearchTest() {
        this.groups = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.iterations = new ArrayList<>();
    }

    @BeforeEach
    public void setup() {

        // Create groups
        groups.add(new Group("Medical Science Group"));
        groups.add(new Group("Economics Science Group"));

        // Create projects
        projects.add(new Project("COVID 19 Vaccine", LocalDate.now().minusDays(10), LocalDate.now().plusDays(10), groups.get(0))); // OPEN date but with all the activities CLOSED
        projects.add(new Project("Amazing Masks", LocalDate.now().plusDays(1), LocalDate.now().plusDays(10), groups.get(0))); // OPEN date but with all the activities OPENED
        projects.add(new Project("New Economic Model", LocalDate.now().minusDays(10), LocalDate.now().minusDays(1), groups.get(1))); // CLOSED date

        // Create iterations
        iterations.add(new Iteration("1. Understand Virus", projects.get(0)));
        iterations.add(new Iteration("2. Create Vaccine", projects.get(0)));

        iterations.add(new Iteration("1. Investigate materials", projects.get(1)));

        iterations.add(new Iteration("1. Design new model", projects.get(2)));

        sabanaResearch = new SabanaResearch(groups);
        // Assert count of plans
        assertEquals(sabanaResearch.countOfGroups(), groups.size(), "The default count of groups");
        assertEquals(sabanaResearch.countOfSummaries(), 0, "The default count of summaries");
    }

    @Test
    @DisplayName("GIVEN sabana research WHEN create summary THEN a new summary is created")
    public void shouldCreateSummary() {
        Summary summary = sabanaResearch.createSummaryEntry();

        assertNotNull(summary, "The summary should be created.");
        assertNotNull(summary.getDate(), "Validate summary date.");
        assertEquals(summary.getActiveProjects(), 1, "Validate number of active projects");
        assertEquals(sabanaResearch.countOfSummaries(), 1, "The default count of summaries");
    }

    @Test
    @DisplayName("GIVEN sabana research WHEN open a project by dates and create summary THEN a new summary is created")
    public void shouldCreateSummaryForOpenProjects() {
        this.projects.get(2).setDateEnd(LocalDate.now().plusDays(1));
        Summary summary = sabanaResearch.createSummaryEntry();

        assertNotNull(summary, "The summary should be created.");
        assertNotNull(summary.getDate(), "Validate summary date.");
        assertEquals(summary.getActiveProjects(), 2, "Validate number of active projects");
        assertEquals(sabanaResearch.countOfSummaries(), 1, "The default count of summaries");
    }

}
