package schedule.entities.decorator;

import schedule.entities.Day;
import schedule.retriever.HolidayRetriever;

public class Holiday extends DayScheduleDecorator {
    private final Day day;

    private HolidayRetriever holidayRetriever;

    public Holiday(Day day) {
        super(day.getDate());
        this.day = day;
        holidayRetriever = new HolidayRetriever();
    }

    @Override
    public boolean isWorkingDay() {
        return day.isWorkingDay() && !holidayRetriever.test(day);
    }

    @Override
    public String toString() {
        return "Holiday {" +
                "date=" + day.getDate() +
                ", workingDay=" + isWorkingDay() +
                '}';
    }
}
