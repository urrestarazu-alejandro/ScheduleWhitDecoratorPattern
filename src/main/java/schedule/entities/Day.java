package schedule.entities;

import lombok.Getter;

import java.util.Date;

@Getter
public class Day {
    private final Date date;
    private final boolean workingDay;

    public Day(Date date) {
        this.date = date;
        this.workingDay = true;
    }

    @Override
    public String toString() {
        return "Day {" +
                "date=" + date +
                ", workingDay=" + workingDay +
                '}';
    }

    public boolean isWorkingDay() {
        return workingDay;
    }
}
