import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
            System.out.println("Invalid initial balance, set to 0");
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }

    public boolean deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount acc;

    ATM(BankAccount acc) {
        this.acc = acc;
    }

    public void withdraw(double amt) {
        if (acc.withdraw(amt)) {
            System.out.println("Withdraw successful. Balance: " + acc.getBalance());
        } else {
            System.out.println("Withdraw failed. Check balance/amount.");
        }
    }

    public void deposit(double amt) {
        if (acc.deposit(amt)) {
            System.out.println("Deposit successful. Balance: " + acc.getBalance());
        } else {
            System.out.println("Deposit failed. Invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + acc.getBalance());
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            System.out.print("Choose option: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter amount: ");
                    double w = sc.nextDouble();
                    withdraw(w);
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double d = sc.nextDouble();
                    deposit(d);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thanks for using ATM");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (ch != 4);
        sc.close();
    }
}

public class task3 {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(5000);
        ATM atm = new ATM(b);
        atm.menu();
    }
}
