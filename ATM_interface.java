import java.util.Scanner;

class Account {
    double balance;

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("invalid amount");
        }

    }

    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("invalid amount");
        } else if (balance < amount) {
            System.err.println("insufficient balance");
        } else {
            balance = balance - amount;
        }

    }

    void check_balance() {

        System.out.println("the account balance is :" + balance);

    }
}

class ATM {

    Scanner sc = new Scanner(System.in);
    Account acc = new Account(); 

    void start() {

        while (true) {

            System.out.println("Enter 1 to deposit");
            System.out.println("Enter 2 to withdraw");
            System.out.println("Enter 3 to check balance");
            System.out.println("Enter 4 to exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter amount to deposit:");
                    double d = sc.nextDouble();
                    acc.deposit(d); 
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double w = sc.nextDouble();
                    acc.withdraw(w); 
                    break;

                case 3:
                    acc.check_balance();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

public class ATM_interface {
    public static void main(String[] args) {
        ATM ac1=new ATM();
        ac1.start();

    }

}