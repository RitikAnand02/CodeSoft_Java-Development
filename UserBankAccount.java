public class UserBankAccount {
    private double balance;

    public UserBankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return String.format("Deposited: $%.2f", amount);
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            return String.format("Withdraw: $%.2f", amount);
        } else if (amount > balance) {
            return "Insufficient balance for this withdrawal.";
        } else {
            return "Invalid withdrawal amount.";
        }
    }

    public String checkBalance() {
        return String.format("Your balance is: $%.2f", balance);
    }
}
