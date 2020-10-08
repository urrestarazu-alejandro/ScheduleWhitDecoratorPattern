package schedule.entities;

import schedule.entities.decorator.DayOfWeek;
import schedule.entities.decorator.Holiday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Schedule {
    List<Day> days;

    public Schedule(Date initialDate, int size) {
        days = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Day day = getDayWhitDecorators(initialDate, i);

            days.add(day);
        }
    }

    private Day getDayWhitDecorators(Date initialDate, int i) {
        Day day = new Day(addDays(initialDate, i));
        day = new Holiday(day);
        day = new DayOfWeek(day);

        return day;
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days); //minus number would decrement the days
        return calendar.getTime();
    }


    public void print() {
        for (Day day : days) {
            System.out.println(day.toString());
        }
    }
}
