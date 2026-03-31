import java.util.Scanner;

class CalcGrade {
    double english, maths, physics, chemistry;

    void inputMarks(double e, double m, double p, double c) {
        english = e;
        maths = m;
        physics = p;
        chemistry = c;
    }

    double totalMarks() {
        return english + maths + physics + chemistry;
    }

    double avgPercentage() {
        return totalMarks() / 4;
    }

    void assignGrade() {
        double percentage = avgPercentage();

        if (percentage >= 90) {
            System.out.println("Grade = A+");
        } else if (percentage >= 80) {
            System.out.println("Grade = A");
        } else if (percentage >= 70) {
            System.out.println("Grade = B");
        } else if (percentage >= 60) {
            System.out.println("Grade = C");
        } else if (percentage >= 50) {
            System.out.println("Grade = D");
        } else {
            System.out.println("Grade = Fail");
        }
    }
}

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CalcGrade s1 = new CalcGrade();

        System.out.print("Enter English marks: ");
        double e = sc.nextDouble();

        System.out.print("Enter Maths marks: ");
        double m = sc.nextDouble();

        System.out.print("Enter Physics marks: ");
        double p = sc.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        double c = sc.nextDouble();

        s1.inputMarks(e, m, p, c);

        double total = s1.totalMarks();
        double percentage = s1.avgPercentage();

        System.out.println("Total Marks = " + total);
        System.out.println("Average Percentage = " + percentage);

        s1.assignGrade();

        sc.close();
    }
}