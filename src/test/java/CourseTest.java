import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseTest {

    @Test(expected=CourseDateException.class)
    public void testEndDateBeforeStartDate() throws CourseDateException {

        // arrange
        String courseName = "TCI";
        Date startDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 15).getTime();
        Date endDate = new GregorianCalendar(2018, Calendar.NOVEMBER, 12).getTime();

        // act
        Course course = new Course(courseName, startDate, endDate);
    }
}
