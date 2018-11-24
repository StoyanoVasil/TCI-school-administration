import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class SchoolTest {

    private String schoolName;
    private Date openingDate;
    private School school;

    @Before
    public void before() throws NullArgumentException {

        // arrange
        schoolName = "Fontys";
        openingDate = new GregorianCalendar(2018, Calendar.AUGUST, 28).getTime();
        school = new School(schoolName, openingDate);
    }

    @Test
    public void testSchoolConstructorInitiatesAllField() {

        // assert
        assertEquals("School name is not set", this.schoolName, school.getName());
        assertEquals("School opening date is not set", this.openingDate, school.getOpeningDate());
        assertEquals("School opening date is not set", 0, school.getNumberOfCourses());
    }

    @Test(expected=NullArgumentException.class)
    public void testSchoolFieldsAreNotNull() throws NullArgumentException {

        // act
        School school = new School(null, null);
    }



    @Test
    public void testAddCourse() throws CourseDateException, CourseException, DuplicateCourseException {

        // arrange
        String courseName = "TCI";
        Date startDate = new GregorianCalendar(2018, Calendar.NOVEMBER, 12).getTime();
        Date endDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 15).getTime();

        // act
        school.addCourse(new Course(courseName, startDate, endDate));

        // assert
        assertEquals("Course not added", 1, school.getNumberOfCourses());
    }

    @Test(expected=CourseException.class)
    public void testAddCourseWithStartingDateBeforeSchoolStartingDate()
            throws CourseException, CourseDateException, DuplicateCourseException {

        // arrange
        String courseName = "TCI";
        Date startDate = new GregorianCalendar(2018, Calendar.MAY, 12).getTime();
        Date endDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 15).getTime();
        Course course = new Course(courseName, startDate, endDate);

        // act
        school.addCourse(course);
    }

    @Test(expected=DuplicateCourseException.class)
    public void testNoDuplicateCourseNames() throws DuplicateCourseException, CourseException, CourseDateException {

        // arrange
        String courseName = "TCI";
        Date startDate = new GregorianCalendar(2018, Calendar.DECEMBER  , 12).getTime();
        Date endDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 15).getTime();
        Course course = new Course(courseName, startDate, endDate);

        // act
        school.addCourse(course);
        school.addCourse(course);
    }

    @Test
    public void testGetCourseByName() throws DuplicateCourseException, CourseException, CourseDateException {

        // arrange
        String courseName = "TCI";
        Date startDate = new GregorianCalendar(2018, Calendar.DECEMBER  , 12).getTime();
        Date endDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 15).getTime();
        Course course = new Course(courseName, startDate, endDate);

        // act
        school.addCourse(course);

        // assert
        assertEquals("Search course not working", course, school.getCourseByName(courseName));
    }

    @Test
    public void testGetAllCourseNames() throws DuplicateCourseException, CourseException, CourseDateException {

        // arrange
        String courseName1 = "TCI";
        String courseName2 = "SAI";
        Date startDate = new GregorianCalendar(2018, Calendar.DECEMBER  , 12).getTime();
        Date endDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 15).getTime();
        Course course1 = new Course(courseName1, startDate, endDate);
        Course course2 = new Course(courseName2, startDate, endDate);

        // act
        school.addCourse(course1);
        school.addCourse(course2);
        ArrayList<String> names = school.getAllCourseNames();

        // assert
        assertTrue("Does not return all added courses names", names.contains(courseName1));
        assertTrue("Does not return all added courses names", names.contains(courseName2));
    }

    @Test
    public void testGetCopyOfAllCourses() throws DuplicateCourseException, CourseException, CourseDateException {

        // arrange
        String courseName1 = "TCI";
        String courseName2 = "SAI";
        Date startDate = new GregorianCalendar(2018, Calendar.DECEMBER  , 12).getTime();
        Date endDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 15).getTime();
        Course course1 = new Course(courseName1, startDate, endDate);
        Course course2 = new Course(courseName2, startDate, endDate);

        // act
        school.addCourse(course1);
        school.addCourse(course2);
        ArrayList<Course> courses = school.getCopyOfAllCourses();

        // assert
        assertEquals("Copy of all courses and school courses are not the same number",
                courses.size(), school.getNumberOfCourses());
        assertNotEquals("Returned a reference not a copy", course1, courses.get(0));
        assertNotEquals("Returned a reference not a copy", course2, courses.get(1));
    }
}
