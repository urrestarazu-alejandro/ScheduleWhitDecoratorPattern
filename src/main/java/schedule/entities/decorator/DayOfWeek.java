package schedule.entities.decorator;


import schedule.retriever.WorkingDayOfWeekRetreiver;

/*
 * Concrete decorator
 */
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
