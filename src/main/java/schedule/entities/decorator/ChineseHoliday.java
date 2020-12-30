package schedule.entities.decorator;

import schedule.entities.Day;
import schedule.retriever.ChineseHolidayRetriever;
import schedule.retriever.HolidayRetriever;

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
