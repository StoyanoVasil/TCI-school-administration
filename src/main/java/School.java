import java.util.ArrayList;
import java.util.Date;

public class School {

    private String name;
    private Date openingDate;
    private ArrayList<Course> courses;

    public School(String name, Date openingDate) throws NullArgumentException {
        if (name == null || openingDate == null) throw new NullArgumentException();
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

    public void addCourse(Course course) throws CourseException, DuplicateCourseException {

        if (course.getStartDate().after(this.openingDate)) {
            Course crs = getCourseByName(course.getName());
            if(crs != null) throw new DuplicateCourseException();
            this.courses.add(course);
        } else {
            throw new CourseException();
        }
    }

    public Course getCourseByName(String courseName) {

        for(Course course : this.courses) {
            if(course.getName().equals(courseName)) return course;
        }
        return null;
    }

    public ArrayList<String> getAllCourseNames() {

        ArrayList<String> names = new ArrayList<>();
        for(Course course : this.courses) names.add(course.getName());
        return names;
    }

    public ArrayList<Course> getCopyOfAllCourses() throws CourseDateException {

        ArrayList<Course> crs = new ArrayList<>();
        for(Course c : this.courses) crs.add(new Course(c.getName(), c.getStartDate(), c.getEndDate()));
        return crs;
    }
}
