package schedule.retriever;

import schedule.entities.Day;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Predicate;

public class HolidayRetriever implements Predicate<Day> {
    @Override
    public boolean test(Day day) {
        LocalDate localDay = day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localHoliday = LocalDate.of(2020, 10, 12);

        return localDay.isEqual(localHoliday);
    }
}
