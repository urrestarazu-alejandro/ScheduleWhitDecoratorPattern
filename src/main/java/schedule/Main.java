package schedule;

import schedule.entities.Schedule;
import schedule.entities.iterator.ScheduleIterator;

import java.util.Date;

public class Main {

    public static final int NUMBER_OF_DAYS = 14;

    public static void main(String[] args) {

        Schedule calendario = new Schedule(new Date(), NUMBER_OF_DAYS, false);

        // you can pass an iterator to a client class
        // instead of giving you access to a collection complete.
        // This way, you do not expose the collection to the customer.
        //
        // And there is another advantage: you can change the way the
        // client works with the collection during the
        // run time by passing a different iterator.
        calendario.show(new ScheduleIterator(calendario));
    }
}
