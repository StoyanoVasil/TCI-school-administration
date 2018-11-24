import java.util.ArrayList;
import java.util.Date;

public class School {

    private String name;
    private Date openingDate;
    private ArrayList<Course> courses;

    public School(String name, Date openingDate) {
        this.name = name;
        this.openingDate = openingDate;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public int getNumberOfCourses() {
        return this.courses.size();
    }
}
