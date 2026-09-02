import java.util.*;

public class Calculate { // CalculatedWeighted method which calculates weighted GPA from grades
    public static double CalculateWeighted(Map<String, List<String>> classes) {
        // initializing variables
        double weightBonus = 0.0;
        double conversionGrade;
        double classSum = 0.0;
        double classGrade;
        for (String key : classes.keySet()) {
            // gets the grade from user input and converts it
            List<String> classList = classes.get(key);
            classGrade = Math.round(Integer.parseInt(classList.get(1)));
            conversionGrade = classGrade - 70;
            if (conversionGrade < 0) {
                conversionGrade = 0.0;
            }
            // giving GPA boost based on weight of either OL, H, or AP
            else {
                if (classList.get(0).equals("OL")) {
                    weightBonus = 1.0;
                }

                if (classList.get(0).equals("H")) {
                    weightBonus = 1.5;
                }

                if (classList.get(0).equals("AP")) {
                    weightBonus = 2.0;
                }

                conversionGrade = (conversionGrade * 0.1) + 1.0 + weightBonus; // formula to get GPA
            }

            classSum += conversionGrade;
        }
        // returns the GPA to the user
        double GPA = classSum / classes.size();
        return GPA;
    }

    // CalculatedUnweighted method which calculates unweighted GPA from grades
    public static double CalculateUnweighted(Map<String, List<String>> classes) {
        // initializing variables
        double conversionGrade;
        double classSum = 0.0;
        double classAverage;
        double classGrade;
        for (String key : classes.keySet()) {
            // convert user input to unweighted GPA
            List<String> classList = classes.get(key);
            classGrade = Math.round(Integer.parseInt(classList.get(1)));
            conversionGrade = (classGrade - 70);
            if (conversionGrade < 0) {
                conversionGrade = 0.0;
            }

            else {
                conversionGrade = Math.ceil((conversionGrade * 0.1)) + 1.0; // formula to get GPA
            }

            classSum += conversionGrade;
        }
        // returns the GPA to the user
        double GPA = classSum / classes.size();
        return GPA;
    }
}