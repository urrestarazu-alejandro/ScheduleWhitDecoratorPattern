package schedule;

import schedule.entities.Schedule;

import java.util.Date;

public class Main {

    public static final int NUMBER_OF_DAYS = 12;

    public static void main(String[] args) {

        Schedule calendario = new Schedule(new Date(), NUMBER_OF_DAYS);

        calendario.print();
    }
}
