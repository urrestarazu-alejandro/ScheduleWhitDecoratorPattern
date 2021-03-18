package schedule.entities.iterator;

import schedule.entities.decorator.Day;
import schedule.entities.Schedule;

import java.util.Iterator;
import java.util.List;

/**
 * The concrete iterator class.
 */
public class ScheduleIterator implements Iterator<Day> {
    // An iterative object runs through the collection
    // independently from another iterator, therefore must
    // store iteration status
    private int currentPosition;
    private List<Day> days;

    public ScheduleIterator(Schedule schedule) {
        this.currentPosition = 0;
        this.days = schedule.getDays();
    }

    @Override
    public boolean hasNext() {
        return days != null &&
                currentPosition < days.size();
    }

    @Override
    public Day next() {
        if (hasNext()) {
            return days.get(currentPosition++);
        }

        return null;
    }
}
