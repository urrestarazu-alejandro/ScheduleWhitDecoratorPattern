package schedule.entities.decorator;

import schedule.entities.Day;

import java.util.Date;


public abstract class DayScheduleDecorator extends Day {
    public DayScheduleDecorator(Date date) {
        super(date);
    }

    public abstract boolean isWorkingDay();
}
