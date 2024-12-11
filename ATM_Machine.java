import java.util.Scanner;

public class ATM_Machine {

    public static void main(String[] args)

    {
        Scanner sc = new Scanner(System.in);

        UserBankAccount uba = new UserBankAccount(2000);
        System.out.println("======ATM======");

        int choice = 0;
        while (choice != 4) {

            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Select Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    System.out.println(uba.withdraw(withdrawAmount));
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    System.out.println(uba.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println(uba.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose between 1 and 4.");
            }
        }
        sc.close();
    }
}
