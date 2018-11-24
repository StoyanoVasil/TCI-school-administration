import java.util.Date;

public class Course {

    private String name;
    private Date startDate;
    private Date endDate;

    public Course(String name, Date startDate, Date endDate) throws CourseDateException {
        if(startDate.before(endDate)) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
        } else {
            throw new CourseDateException("Start date should be before end date!");
        }
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
