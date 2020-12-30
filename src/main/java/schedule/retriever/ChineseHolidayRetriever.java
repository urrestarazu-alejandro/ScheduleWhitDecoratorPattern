package schedule.retriever;

import schedule.entities.Day;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Predicate;

public class ChineseHolidayRetriever implements Predicate<Day> {

    public static final LocalDate CHINESE_NEW_YEAR = LocalDate.of(2021, 1, 7);

    @Override
    public boolean test(Day day) {
        LocalDate localDay = day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return localDay.isEqual(CHINESE_NEW_YEAR);
    }
}
