import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Stack;

public class JavaConf2020 {
    static BufferedReader input;
    static String filePath;
    static boolean fileExists = false;
    static ArrayList<String> inputFile;
    static String errorMessage;
    static int counter = 0;

    public static void main(String[] args) throws IOException {

        getFile();
        int emptyStringCount;

        inputFile = (ArrayList<String>) Files.readAllLines(Path.of(filePath));//reads file as arraylist

        ArrayList<String> title = new ArrayList<>();
        ArrayList<Integer> minuets = new ArrayList<>();

        for( String talk: inputFile){
            String[] str = talk.split("    ");
            title.add(str[0]);
            minuets.add(Integer.valueOf(str[1]));
        }//puts the talk titles in an arraylist and the talk times in an array list




        HashMap<Integer, Stack<String>> sessions = new HashMap<>();
        ArrayList<String> scheduleList = new ArrayList<>();
        Schedule testSchedule = new Schedule(195, sessions, scheduleList);

        for(int i = 0; i < title.size(); i++){
            testSchedule.addSession(minuets.get(i), title.get(i));
        }

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

    static void getFile() throws IOException {//inputing a file
        input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the path of the file you would like to format: ");

        do {
            try {
                filePath = input.readLine();

                if (!Files.exists(Path.of(filePath)) || filePath.equals("")) {
                    throw new InputMismatchException();
                }
                else {
                    fileExists = true;
                }
            } catch (InputMismatchException e) {
                errorMessage = "File not found. Please enter a valid file path.";
                System.out.println(errorMessage);
            }

        } while (!fileExists);
    }

}
