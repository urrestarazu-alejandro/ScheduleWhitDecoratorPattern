package schedule.retriever;

import schedule.entities.Day;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class WorkingDayOfWeekRetreiver implements Predicate<Day> {
    private final List<Integer> diasHabiles = Arrays.asList(Calendar.MONDAY,
            Calendar.TUESDAY,
            Calendar.WEDNESDAY,
            Calendar.THURSDAY,
            Calendar.FRIDAY);

    @Override
    public boolean test(Day day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day.getDate());
        int dow = calendar.get(Calendar.DAY_OF_WEEK);

        return diasHabiles.contains(dow);
    }
}
