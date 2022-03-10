import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Schedule {

    // These ints will hold the total number of minutes available in each track
    private int track1MinutesAvailable;
    private int track2MinutesAvailable;
    /*
    This hashmap is for storing the sessions. Because hashmap have unique keys,
    The key would be the number of minutes in the session. The Stacks will
    hold the string representations of each session with the corresponding number
    of minutes. So if 3 sessions are each 45 minutes long, then the key 45 will
    contain a stack of 3 strings. When the string has been added to the scheduleList,
    the stack can be popped to make way for the next session.
    */
    private HashMap<Integer, Stack<String>> sessions = new HashMap<>();
    private ArrayList<String> scheduleList = new ArrayList<>();

    // Empty constructor
    public Schedule() {
    }

    // Fully Parameterized constructor
    public Schedule(int track1MinutesAvailable, int track2MinutesAvailable,
                    HashMap<Integer, Stack<String>> sessions, ArrayList<String> scheduleList) {

        this.track1MinutesAvailable = track1MinutesAvailable;
        this.track2MinutesAvailable = track2MinutesAvailable;
        this.sessions = sessions;
        this.scheduleList = scheduleList;

    }

    // Constructor with only 1 track for testing purposes
    public Schedule(int track1MinutesAvailable, HashMap<Integer, Stack<String>> sessions,
                    ArrayList<String> scheduleList) {

        this.track1MinutesAvailable = track1MinutesAvailable;
        this.sessions = sessions;
        this.scheduleList = scheduleList;

    }

    public int getTrack1MinutesAvailable() {

        return track1MinutesAvailable;

    }

    public void setTrack1MinutesAvailable(int track1MinutesAvailable) {

        this.track1MinutesAvailable = track1MinutesAvailable;

    }

    public int getTrack2MinutesAvailable() {

        return track2MinutesAvailable;

    }

    public void setTrack2MinutesAvailable(int track2MinutesAvailable) {

        this.track2MinutesAvailable = track2MinutesAvailable;

    }

    public HashMap<Integer, Stack<String>> getSessions() {

        return sessions;

    }

    public void setSessions(HashMap<Integer, Stack<String>> sessions) {

        this.sessions = sessions;

    }

    public void addSession(int key, String session) {

        if (sessions.containsKey(key)) {
            Stack<String> plusOne = sessions.get(key);
            plusOne.push(session);
            sessions.put(key, plusOne);
        }
        else {
            Stack<String> plusOne = new Stack<>();
            plusOne.push(session);
            sessions.put(key, plusOne);
        }

    }

    public void removeSession(int key, String session) {

        if (sessions.containsKey(key)) {
            Stack<String> plusOne = sessions.get(key);
            plusOne.remove(session);
            sessions.put(key, plusOne);
        }

    }

    public ArrayList<String> getScheduleList() {

        return scheduleList;

    }

    public void setScheduleList(ArrayList<String> scheduleList) {

        this.scheduleList = scheduleList;

    }

    public void addToTrack1(int minutes) {

        if (track1MinutesAvailable - minutes < 0) {
            System.out.println("That track does not " +
                    "have enough time left. Required: " + (track1MinutesAvailable - minutes) +
                    " Available: " + (track1MinutesAvailable));
        }
        else {
            track1MinutesAvailable = track1MinutesAvailable - minutes;
            scheduleList.add(sessions.get(minutes).peek());
            sessions.get(minutes).pop();
        }

    }

}
