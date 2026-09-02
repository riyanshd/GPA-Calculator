import java.util.Scanner;

public class Tutorial { // RunTutorial method to show the user how to use the program
    public static void RunTutorial() {
        // to take user input
        Scanner sc = new Scanner(System.in);
        String input = "";

        // showing the user an example of the grades and classes that are usually put
        // into the calculator
        System.out.println("Suppose you were to put these grades into the calculator:\n\n"
                + "Honors Geometry: 92\n"
                + "H English I: 88\n"
                + "H Biology: 98\n"
                + "AP Human Geography: 81\n"
                + "OL Spanish I: 90\n"
                + "OL Art I: 99\n"
                + "H Computer Science I: 95\n");
        // makes the tutorial keep running
        while (true) { // shows the user how to use the ADD function to add classes
            System.out.print("Type 'ADD'\n>> ");
            input = sc.next();

            if (input.equalsIgnoreCase("ADD")) {
                System.out.println("Subject>> Algebra I");
                System.out.println("Weight>> H");
                System.out.println("Grade>> 95");
                System.out.println("\nThe 'ADD' function allows you to add a class to your list:");
                System.out.println("\nClasses\n"
                        + "Honors Geometry: 92\n"
                        + "H English I: 88\n"
                        + "H Biology: 98\n"
                        + "AP Human Geography: 81\n"
                        + "OL Spanish I: 90\n"
                        + "OL Art I: 99\n"
                        + "H Computer Science I: 95\n"
                        + "H Algebra I: 95\n");

                break;
            }
        }
        // keeps tutorial running
        while (true) { // shows the user how to use the REMOVE function to remove classes
            System.out.print("Type 'REMOVE'\n>> ");
            input = sc.next();

            if (input.equalsIgnoreCase("REMOVE")) {
                System.out.println("Subject>> English I");
                System.out.println("Weight>> H");
                System.out.println("Grade>> 88");
                System.out.println("\nThe 'REMOVE' function allows you to remove a class from your list:");
                System.out.println("\nClasses\n"
                        + "Honors Geometry: 92\n"
                        + "H Biology: 98\n"
                        + "AP Human Geography: 81\n"
                        + "OL Spanish I: 90\n"
                        + "OL Art I: 99\n"
                        + "H Computer Science I: 95\n"
                        + "H Algebra I: 95\n");

                break;
            }
        }
        // keeps the tutorial running
        while (true) { // shows the user how to use the VIEW function to see their classes
            System.out.print("Type 'VIEW'\n>> ");
            input = sc.next();

            if (input.equalsIgnoreCase("VIEW")) {
                System.out.println("\nThe 'VIEW' function allows you to see your classes:");
                System.out.println("\nClasses\n"
                        + "Honors Geometry: 92\n"
                        + "H Biology: 98\n"
                        + "AP Human Geography: 81\n"
                        + "OL Spanish I: 90\n"
                        + "OL Art I: 99\n"
                        + "H Computer Science I: 95\n"
                        + "H Algebra I: 95\n");

                break;
            }
        }

        // tells the user about different functions that the user can do like TUTORIAL
        // and PREDICT
        System.out.println("Some other useful functions are: \n"
                + "'TUTORIAL' allows you to replay this tutorial whenever you want to\n"
                + "'PREDICT' allows you to predict SAT/ACT scores based on your GPA\n"
                + "'CALCULATE' allows you to calculate your weighted and unweighted GPA\n"
                + "'BACK' allows you to go back to the previous section (Remove to Command)\n"
                + "'QUIT' allows you to exit the program in the profile section");

    }

}