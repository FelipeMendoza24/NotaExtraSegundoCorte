package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StudentSynthesizer implements ISynthesizer{
    public List<Student> students;
    public ArrayList<String> summary;

    public StudentSynthesizer(List<Student> students) {
        this.students = students;
    }

    @Override
    public List <String> synthezise() throws SabanaResearchException{

        String name = null;

        Duration d = Duration.ZERO;
        for (Student s : this.students){
            d=s.getDuration();
            name = s.getName();
            summary.add("Student: "+ name);
        }
        return summary;
    }
}
