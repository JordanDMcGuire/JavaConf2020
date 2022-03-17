import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class JavaConf2020 {
    static BufferedReader input;
    static String filePath;
    static boolean fileExists = false;
    static ArrayList<String> inputFile;
    static String errorMessage;
    static String printChecker;
    // Create the schedule object
    static Schedule schedule = new Schedule();

    public static void main(String[] args) throws IOException {

        getFile();

        // Reads file as arraylist
        inputFile = (ArrayList<String>) Files.readAllLines(Path.of(filePath));

        ArrayList<String> title = new ArrayList<>();
        ArrayList<Integer> minutes = new ArrayList<>();

        // Puts the talk titles in an arraylist and the talk times in an array list
        for(String talk: inputFile){
            String[] str = talk.split("    ");
            title.add(str[0]);
            if (str[1].equals("Lightning")) {
                minutes.add(5);
            }
            else {
                minutes.add(Integer.parseInt(str[1].substring(0, 2)));
            }
        }

        // Fill the sessions structure in the schedule object
        for(int i = 0; i < title.size(); i++){
            schedule.addSession(minutes.get(i), title.get(i));
        }

        // Let the program decide which order sessions are in
        schedule.shuffle();
        schedule.shuffle();
        schedule.shuffle();

        // Fill and print
        schedule.fill();
        System.out.println(schedule);

    }

    // input a file
    static void getFile() throws IOException {

        System.out.println("Please enter the path of the file you would like to format: ");

        do {
            try {
                input = new BufferedReader(new InputStreamReader(System.in));
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
            } catch (InvalidPathException e) {
                errorMessage = "Illegal character found. Please enter a valid file path.";
                System.out.println(errorMessage);
            }

        } while (!fileExists);
    }

}
