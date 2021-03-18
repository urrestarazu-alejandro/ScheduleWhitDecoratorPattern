package schedule.entities.decorator;

import java.util.Date;

/*
 * Decorator
 */
public abstract class DayScheduleDecorator extends Day {
    protected DayScheduleDecorator(Date date) {
        super(date);
    }

    // Single responsibility
    @Override
    public abstract boolean isWorkingDay();
}
