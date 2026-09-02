import java.io.*;
import java.util.*;

public class File {
    // initializes the studentFile and makes the text file student_data.txt
    private static String studentFile = "student_data.txt";

    // saveData method which writes the user data to the text file
    public static void saveData(String name, Map<String, List<String>> classes) {
        try { // writes the user input to the data file and saves it
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentFile, true));
            { // saves the profile name with the student name
                writer.write("Student: " + name + "\n");
                for (Map.Entry<String, List<String>> entry : classes.entrySet()) { // writes the remaining thing
                    String subject = entry.getKey();
                    List<String> classDetails = entry.getValue();
                    writer.write(subject + "," + classDetails.get(0) + "," + classDetails.get(1) + "\n");
                }

                writer.write("----\n");
                System.out.println("Data saved successfully. ");
                writer.close();
            }
        }
        // catches any errors and prints it back to the user
        catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // returns the profile name, class, weight, and grade that the user gave
    public static Map<String, Map<String, List<String>>> loadData() {
        Map<String, Map<String, List<String>>> data = new HashMap<>();
        try { // reads it out to the user
            BufferedReader reader = new BufferedReader(new FileReader(studentFile));
            String line;
            String currentStudent = null;
            Map<String, List<String>> classes = new HashMap<>();

            while ((line = reader.readLine()) != null) { // checks what student the data is for
                if (line.startsWith("Student: ")) {
                    if (currentStudent != null) {
                        data.put(currentStudent, new HashMap<>(classes));
                        classes.clear();
                    }
                    currentStudent = line.substring(9).trim();
                }
                // data for the next student
                else if (line.equals("----")) {
                    if (currentStudent != null) {
                        data.put(currentStudent, classes);
                        currentStudent = null;
                    }
                }

                else { // splits the data by class, grade, and weight
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        classes.put(parts[0], Arrays.asList(parts[1], parts[2]));
                    }
                }
            }
            // safety measure to add data if code doesn't work correctly
            if (currentStudent != null) {
                data.put(currentStudent, classes);
            }

            reader.close();
        }
        // catches errors again and reports to the user
        catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return data;
    }
}