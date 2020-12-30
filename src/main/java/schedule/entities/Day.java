package schedule.entities;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class Day {
    public static final String VERTICAL_PIPE = " | \t";

    private final Date date;
    private final boolean workingDay;

    public Day(Date date) {
        this.date = date;
        this.workingDay = true;
    }

    public void show() {
        String line = VERTICAL_PIPE +
                new SimpleDateFormat("EEE | dd/MM/yyyy").format(date) +
                VERTICAL_PIPE +
                (this.isWorkingDay() ? " " : "X") +
                VERTICAL_PIPE;
        System.out.println(line);
    }

    public boolean isWorkingDay() {
        return workingDay;
    }
}
