import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class JavaConf2020 {

    public static void main(String[] args) {

        HashMap<Integer, Stack<String>> sessions = new HashMap<>();
        ArrayList<String> scheduleList = new ArrayList<>();
        Schedule testSchedule = new Schedule(195, sessions, scheduleList);

        int key45 = 45;
        int key30 = 30;

        String session1 = "Java and Containers - Make it Awesome! - 45 min";
        String session2 = "Memory Efficient Java - 45 min";
        String session3 = "Discover Modern Java - 45 min";

        String session4 = "Java: Did you Know That? - 30 min";
        String session5 = "Property-Based Testing in Java - 30 min";

        testSchedule.addSession(key45, session1);
        testSchedule.addSession(key45, session2);
        testSchedule.addSession(key45, session3);
        testSchedule.addSession(key30, session4);
        testSchedule.addSession(key30, session5);

        // state 1
        System.out.println("State 1: ");
        System.out.println("Total Sessions Available: " + testSchedule.getSessions());
        System.out.println("Schedule: " + testSchedule.getScheduleList());

        testSchedule.addToTrack1(key30);

        // state 2
        System.out.println();
        System.out.println("State 2: ");
        System.out.println("Total Sessions Available: " + testSchedule.getSessions());
        System.out.println("Schedule: " + testSchedule.getScheduleList());

        testSchedule.addToTrack1(key30);

        // state 3
        System.out.println();
        System.out.println("State 3: ");
        System.out.println("Total Sessions Available: " + testSchedule.getSessions());
        System.out.println("Schedule: " + testSchedule.getScheduleList());

        testSchedule.addToTrack1(key45);
        testSchedule.addToTrack1(key45);

        // state 4
        System.out.println();
        System.out.println("State 4: ");
        System.out.println("Total Sessions Available: " + testSchedule.getSessions());
        System.out.println("Schedule: " + testSchedule.getScheduleList());

    }
}
