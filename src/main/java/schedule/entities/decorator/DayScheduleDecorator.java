package schedule.entities.decorator;

import schedule.entities.Day;

import java.util.Date;
import java.util.List;


public abstract class DayScheduleDecorator extends Day {
    protected DayScheduleDecorator(Date date) {
        super(date);
    }

    @Override
    public abstract boolean isWorkingDay();
}
