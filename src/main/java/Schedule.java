
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class Schedule {

    // These ints will hold the total number of minutes available in each track
    private int track1MorningMinutesAvailable;
    private int track1AfternoonMinutesAvailable;
    private int track2MorningMinutesAvailable;
    private int track2AfternoonMinutesAvailable;
    private SessionTime sessionTime;
    /*
    This hashmap is for storing the sessions. Because hashmap have unique keys,
    The key would be the number of minutes in the session. The Stacks will
    hold the string representations of each session with the corresponding number
    of minutes. So if 3 sessions are each 45 minutes long, then the key 45 will
    contain a stack of 3 strings. When the string has been added to the scheduleList,
    the stack can be popped to make way for the next session.
    */
    private final HashMap<Integer, Stack<String>> sessions;
    private final ArrayList<String> scheduleList;

    // Default constructor
    public Schedule() {

        this.track1MorningMinutesAvailable = 180;
        this.track1AfternoonMinutesAvailable = 240;
        this.track2MorningMinutesAvailable = 180;
        this.track2AfternoonMinutesAvailable = 240;
        this.sessions = new HashMap<>();
        this.scheduleList = new ArrayList<>();
        sessionTime = new SessionTime(9,0, "AM");

    }

    @Override
    public String toString() {

        StringBuilder scheduleString = new StringBuilder();

        for (String element : scheduleList) {
            scheduleString.append(element).append("\n");
        }

        JavaConf2020.printChecker = scheduleString.toString();

        return scheduleString.toString();

    }

    // Begin special behaviors

    // Simulate random order for schedule
    public void shuffle() {
        for (int i = 0; i <= 60; i += 5) {
            if (sessions.containsKey(i)) {
                Collections.shuffle(sessions.get(i));
            }
        }
    }

    // Put a session in the schedule and delete it from the stack
    public void addSession(int key, String session) {

        Stack<String> plusOne;

        if (sessions.containsKey(key)) {
            plusOne = sessions.get(key);
        }
        else {
            plusOne = new Stack<>();
        }

        plusOne.push(session);
        sessions.put(key, plusOne);

    }

    // Begin schedule fill methods
    public void addToTrack1Morning(int minutes) {

        if (track1MorningMinutesAvailable - minutes >= 0) {
            track1MorningMinutesAvailable = track1MorningMinutesAvailable - minutes;
            if (minutes == 5) {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    lightning");
            }
            else {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    " + minutes + "min");
            }
            sessions.get(minutes).pop();
            sessionTime.add(minutes);
        }

    }

    public void addToTrack1Afternoon(int minutes) {

        if (track1AfternoonMinutesAvailable - minutes >= 0) {
            track1AfternoonMinutesAvailable = track1AfternoonMinutesAvailable - minutes;
            if (minutes == 5) {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    lightning");
            }
            else {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    " + minutes + "min");
            }
            sessions.get(minutes).pop();
            sessionTime.add(minutes);
        }

    }

    public void addToTrack2Morning(int minutes) {

        if (track2MorningMinutesAvailable - minutes >= 0) {
            track2MorningMinutesAvailable = track2MorningMinutesAvailable - minutes;
            if (minutes == 5) {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    lightning");
            }
            else {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    " + minutes + "min");
            }
            sessions.get(minutes).pop();
            sessionTime.add(minutes);
        }

    }

    public void addToTrack2Afternoon(int minutes) {

        if (track2AfternoonMinutesAvailable - minutes >= 0) {
            track2AfternoonMinutesAvailable = track2AfternoonMinutesAvailable - minutes;
            if (minutes == 5) {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    lightning");
            }
            else {
                scheduleList.add(sessionTime + "    " + sessions.get(minutes).peek() + "    " + minutes + "min");
            }
            sessions.get(minutes).pop();
            sessionTime.add(minutes);
        }

    }

    public void fill() {

        scheduleList.add("Track 1:");
        addToTrack1Morning(60);
        addToTrack1Morning(45);
        addToTrack1Morning(30);
        addToTrack1Morning(45);
        scheduleList.add(sessionTime + "    Lunch");
        sessionTime.add(60);
        addToTrack1Afternoon(60);
        addToTrack1Afternoon(45);
        addToTrack1Afternoon(45);
        addToTrack1Afternoon(30);
        addToTrack1Afternoon(30);
        addToTrack1Afternoon(30);
        scheduleList.add(sessionTime + "    Networking Event");
        sessionTime = new SessionTime(9,0, "AM");
        scheduleList.add("");
        scheduleList.add("Track 2:");
        addToTrack2Morning(60);
        addToTrack2Morning(60);
        addToTrack2Morning(30);
        addToTrack2Morning(30);
        scheduleList.add(sessionTime + "    Lunch");
        sessionTime.add(60);
        addToTrack2Afternoon(45);
        addToTrack2Afternoon(45);
        addToTrack2Afternoon(30);
        addToTrack2Afternoon(60);
        addToTrack2Afternoon(5);
        sessionTime.add(55);
        scheduleList.add(sessionTime + "    Networking Event");

    }

}
