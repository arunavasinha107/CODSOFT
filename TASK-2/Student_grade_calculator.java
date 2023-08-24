import java.util.Scanner;
public class Student_grade_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Total No. of Subjects: ");
        int subjects = sc.nextInt();
        int marks;
        int total_Marks = 0;
        double avg_percentage;
        String grade = "";
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter the No. " + i + " " + "Subject Marks: ");
            marks = sc.nextInt();
            if (marks > 100) {
                System.out.println("less than 100 marks are allowed");
                return;
            }
            total_Marks = total_Marks + marks;
        }

        avg_percentage = (double) total_Marks / (subjects * 100) * 100;
        if (avg_percentage >= 90)
            grade = "A";
        else if (avg_percentage >= 80)
            grade = "B";
        else if (avg_percentage >= 70)
            grade = "C";
        else if (avg_percentage >= 60)
            grade = "D";
        else
            grade = "F";

        System.out.println("Total Marks " + total_Marks);
        System.out.println(String.format("Average Percentage %.2f ", avg_percentage));
        System.out.println("Grade " + grade);
    }
}