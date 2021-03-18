package schedule.entities.decorator;

import schedule.retriever.ChineseHolidayRetriever;

/*
 * Concrete decorator
 */
public class ChineseHoliday extends DayScheduleDecorator {
    private final Day day;

    private ChineseHolidayRetriever chineseHolidayRetriever;

    public ChineseHoliday(Day day) {
        super(day.getDate());
        this.day = day;
        chineseHolidayRetriever = new ChineseHolidayRetriever();
    }

    @Override
    public boolean isWorkingDay() {
        return day.isWorkingDay() &&
                !chineseHolidayRetriever.test(day);
    }
}
