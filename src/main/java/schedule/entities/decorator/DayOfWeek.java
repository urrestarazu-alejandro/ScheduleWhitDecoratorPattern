package schedule.entities.decorator;


import schedule.entities.Day;
import schedule.retriever.WorkingDayOfWeekRetreiver;

public class DayOfWeek extends DayScheduleDecorator {
    private final Day day;

    private WorkingDayOfWeekRetreiver workingDayOfWeekRetreiver;

    public DayOfWeek(Day day) {
        super(day.getDate());
        this.day = day;
        workingDayOfWeekRetreiver = new WorkingDayOfWeekRetreiver();
    }

    @Override
    public boolean isWorkingDay() {
        return day.isWorkingDay() &&
                workingDayOfWeekRetreiver.test(day);
    }
}
