package schedule.entities.decorator;

import schedule.retriever.HolidayRetriever;

/*
 * Concrete decorator
 */
public class Holiday extends DayScheduleDecorator {
    private final Day day;
    private final HolidayRetriever holidayRetriever;

    public Holiday(Day day) {
        super(day.getDate());
        this.day = day;
        holidayRetriever = new HolidayRetriever();
    }

    @Override
    public boolean isWorkingDay() {
        return day.isWorkingDay() &&
                !holidayRetriever.test(day);
    }
}
