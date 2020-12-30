package schedule.retriever;

import schedule.entities.Day;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Predicate;

public class HolidayRetriever implements Predicate<Day> {

    public static final LocalDate PERONCHO_DAY = LocalDate.of(2021, 1, 1);

    @Override
    public boolean test(Day day) {
        LocalDate localDay = day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return localDay.isEqual(PERONCHO_DAY);
    }
}
