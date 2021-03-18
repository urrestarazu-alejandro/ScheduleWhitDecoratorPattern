package schedule.entities;

import schedule.entities.decorator.ChineseHoliday;
import schedule.entities.decorator.Day;
import schedule.entities.decorator.DayOfWeek;
import schedule.entities.decorator.Holiday;
import schedule.entities.iterator.ScheduleIterator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Schedule {
    private List<Day> days;
    private Integer size;
    private Date initialDate;
    private boolean isChinese;

    public Schedule(Date initialDate, int size, boolean isChinese) {
        this.size = size;
        this.initialDate = initialDate;
        this.isChinese = isChinese;
    }

    /**
     * a day generator
     *
     * @return
     */
    public List<Day> getDays() {
        days = new ArrayList<>();

        for (int i = 0; i < this.size; i++) {
            Day day = getDayWhitDecorators(addDays(this.initialDate, i));

            days.add(day);
        }

        return days;
    }

    /**
     * Applies decorators
     *
     * @param creation
     * @return
     */
    private Day getDayWhitDecorators(Date creation) {
        // Concrete component
        Day day = new Day(creation);

        //Stack of decorators
        day = new Holiday(day);
        day = new DayOfWeek(day);

        if (isChinese) {
            day = new ChineseHoliday(day);
        }

        return day;
    }

    /**
     * sum an amount of days to a date
     */
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days); //minus number would decrement the days
        return calendar.getTime();
    }

    public void show(ScheduleIterator scheduleIterator) {
        System.out.println("Schedule (X indicates non-working day)");

        for (ScheduleIterator it = scheduleIterator; it.hasNext(); ) {
            Day day = it.next();
            day.show();
        }
    }
}
