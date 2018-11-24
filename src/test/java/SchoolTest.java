import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
}
