public class Predict { // PredictSAT method which would say SAT score based on GPA
    public static void PredictSAT(double gpa) {
        // calculating the SAT score my multiplying and adding GPA
        double predicted = (300 * gpa) + 400;
        System.out.println("Predicted SAT Score: " + (Math.round(predicted) / 10) * 10);

    }// PredictACT method which would say ACT score based on GPA

    public static void PredictACT(double gpa) {
        // calculating ACT score my multiplying and adding GPA
        double predicted = (7.5 * gpa) + 6;
        System.out.println("Predicted ACT Score: " + Math.round(predicted));
    }

}