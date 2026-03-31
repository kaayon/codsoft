class calc_grade {
    double english, maths, physics, chemistry;

    void input_marks(double x, double y, double z, double w) {

        english = x;
        maths = y;
        physics = z;
        chemistry = w;

    }

    void total_marks() {
        double result = english + maths + physics + chemistry;
        System.out.println("total marks = "+  result);
    }

    void avg_percentage() {
        double percentage = (english + maths + physics + chemistry);
        System.out.println("avg percentage = "+  percentage);
    }

    void assign_grade() {
        double percentage = (english + maths + physics + chemistry);

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

public class grade_calculator {
    public static void main(String[] args) {
        calc_grade s1 = new calc_grade();

        s1.input_marks(93, 75, 90, 67);

        s1.total_marks();

        s1.avg_percentage();

        s1.assign_grade();
    }
}