
import java.util.*; //import util library

//main class
public class Main {
    // main method
    public static void main(String[] args) {
        // loop so the user can use multiple profiles (different classes) without
        // re-running the code
        while (true) {

            Scanner sc = new Scanner(System.in); // declare scanner

            // ask for the profile name
            System.out.print("Welcome to GPA Genius, Please enter your name: ");
            String studentName = sc.nextLine();

            // if the user wants to end the program
            if (studentName.equalsIgnoreCase("QUIT")) {
                break;
            }

            // create the classes map (stores subject, weight, grade)
            Map<String, List<String>> classes = new HashMap<>();
            classes = File.loadData().get(studentName); // load data from the file

            // if the profile doesn't exist (so it can't access classes)
            if (classes == null) {
                classes = new HashMap<>(); // initialize classes to a new map
                System.out.print("Would you like a tutorial (y/n)? "); // instance message
                String t = sc.nextLine(); // temporary

                // check if the user wants to see the tutorial
                if (t.equals("y")) {
                    Tutorial.RunTutorial();
                }
            } else if (classes != null) {
                System.out.println("Welcome back!");
            }

            // once in a profile, the user can input commands
            while (true) {
                // command prompt
                System.out.print(">> ");
                String commandInput = sc.nextLine();
                // initialize important variables
                String subject = "";
                String weight = "";
                String grade = "";

                // if the user exits the profile, save the profile data
                if (commandInput.equalsIgnoreCase("BACK")) {
                    File.saveData(studentName, classes);
                    break;
                }

                // if the user wants to replay the tutorial
                else if (commandInput.equalsIgnoreCase("TUTORIAL")) {
                    Tutorial.RunTutorial();
                }

                // if the user wants to add a class
                else if (commandInput.equalsIgnoreCase("ADD")) {
                    // ask for class input
                    System.out.println("\nInput Class to Add Here: ");
                    while (true) {
                        // subject/class name
                        System.out.print("Subject>> ");
                        subject = sc.nextLine();

                        // if the user wants to leave before they've added the class
                        if (subject.equalsIgnoreCase("BACK")) {
                            break;
                        }

                        // check if the user inputs a correct weight (otherwise an error)
                        while (true) {
                            // weighting of the class (AP/H/OL)
                            System.out.print("Weight[OL, H, AP]>> ");
                            weight = sc.nextLine().toUpperCase();

                            // check if the user inputted a correct weighting
                            if (weight.equals("AP") || weight.equals("H") || weight.equals("OL")) {
                                break;
                            } else {
                                System.out.println("Not an option. Try again.");
                            }
                        }

                        // check for grade; just to see if its between 0 and 100
                        int numericGrade = 0;

                        while (true) {
                            // user's grade in the class
                            System.out.print("Grade>> ");
                            grade = sc.nextLine();

                            try {
                                // check if its an integer
                                numericGrade = Integer.parseInt(grade);

                                // check if grade exceeds upper limit
                                if (numericGrade > 100) {
                                    System.out.println("Grade exceeds upper limit (100). Try again. ");
                                    continue;
                                }

                                // check if grade exceeds lower limit
                                else if (numericGrade < 0) {
                                    System.out.println("Grade exceeds lower limit (0). Try again. ");
                                    continue;
                                }

                                break;
                            }

                            // catch any errors
                            catch (Exception e) {
                                System.out.println("Did not input an integer. Try again. ");
                            }
                        }
                        // print out the class and grade that the user inputs
                        classes.put(subject, Arrays.asList(weight, grade));
                        System.out.println("\nYour classes: ");

                        for (Map.Entry<String, List<String>> entry : classes.entrySet()) {
                            subject = entry.getKey();
                            List<String> classDetails = entry.getValue();
                            System.out.println(classDetails.get(0) + " " + subject + ": " + classDetails.get(1) + "\n");
                        }
                    }
                }
                // remove tool which gives the user a way to remove classes
                else if (commandInput.equalsIgnoreCase("REMOVE")) {
                    System.out.println("\nInput Class to Remove Here: ");

                    while (true) {
                        System.out.print(">> ");
                        subject = sc.nextLine();

                        if (subject.equalsIgnoreCase("BACK")) {
                            break;
                        }
                        // checks to see if subject exists and if it does it gets removed
                        if (classes.containsKey(subject)) {
                            classes.remove(subject);

                            // print out subjects for re-reference
                            System.out.println("\nYour classes: ");
                            for (Map.Entry<String, List<String>> entry : classes.entrySet()) {
                                subject = entry.getKey();
                                List<String> classDetails = entry.getValue();
                                System.out.println(classDetails.get(0) + " " + subject + ": " + classDetails.get(1));
                            }

                            System.out.println();
                        } else // if the class doesn't exist
                        {
                            System.out.println("Class not registered. Try again or exit.");
                        }
                    }
                } else if (commandInput.equalsIgnoreCase("VIEW")) // view command to see classes
                {
                    if (classes.isEmpty()) // if the user hasn't inputted classes
                    {
                        System.out.println("No classes inputted. ");
                    } else // if the user has inputted classes
                    {
                        // print out classes
                        System.out.println("\nYour classes: ");

                        for (Map.Entry<String, List<String>> entry : classes.entrySet()) {
                            // print out classes
                            subject = entry.getKey();
                            List<String> classDetails = entry.getValue();
                            System.out.println(classDetails.get(0) + " " + subject + ": " + classDetails.get(1));
                        }
                    }
                }
                // calculate GPA
                else if (commandInput.equalsIgnoreCase("CALCULATE")) {

                    // check if the user hasn't inputted any classes
                    if (classes.isEmpty()) {
                        System.out.println(
                                "No classes inputted. Try again once you've inputted classes using the 'ADD' command");
                    }

                    // if the user inputted classes
                    else {
                        // print weighted
                        double wGPA = Calculate.CalculateWeighted(classes);
                        System.out.printf("Your weighted class GPA is: %.3f", wGPA);

                        // print unweighted
                        double uwGPA = Calculate.CalculateUnweighted(classes);
                        System.out.printf("\nYour unweighted class GPA is: %.3f\n", uwGPA);
                    }
                }
                // predict SAT/ACT
                else if (commandInput.equalsIgnoreCase("PREDICT")) {
                    // use calculate to recalculate before predicting
                    Predict.PredictSAT(Calculate.CalculateUnweighted(classes));
                    Predict.PredictACT(Calculate.CalculateUnweighted(classes));
                }
            }
        }
    }
}