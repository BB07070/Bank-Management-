import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("     BANKING MANAGEMENT SYSTEM");
        System.out.println("==================================");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        performDeposit();
                        break;
                    case 3:
                        performWithdrawal();
                        break;
                    case 4:
                        checkBalance();
                        break;
                    case 5:
                        displayAccount();
                        break;
                    case 6:
                        bank.displayAllAccounts();
                        break;
                    case 7:
                        running = false;
                        System.out.println("Thank you for using our banking system.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1 to 7.");
                }
            } catch (BankingException e) {
                System.out.println("Banking error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n----------- MAIN MENU -----------");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Check account balance");
        System.out.println("5. Display account details");
        System.out.println("6. Display all accounts");
        System.out.println("7. Exit");
    }

    private static void createAccount() throws BankingException {
        System.out.println("\\nChoose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int type = readInt("Enter account type: ");

        System.out.print("Enter account number: ");
        String number = scanner.nextLine().trim();
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine().trim();
        double openingBalance = readDouble("Enter opening balance: Rs. ");

        // Parent-class reference can refer to either child class (polymorphism).
        Account account;
        if (type == 1) {
            account = new SavingsAccount(number, name, openingBalance);
        } else if (type == 2) {
            account = new CurrentAccount(number, name, openingBalance);
        } else {
            throw new BankingException("Invalid account type.");
        }

        bank.addAccount(account);
        System.out.println(account + " created successfully.");
    }

    private static Account getAccountFromUser() throws BankingException {
        System.out.print("Enter account number: ");
        String number = scanner.nextLine().trim();
        Account account = bank.findAccount(number);
        if (account == null) {
            throw new BankingException("Account not found.");
        }
        return account;
    }

    private static void performDeposit() throws BankingException {
        Account account = getAccountFromUser();
        double amount = readDouble("Enter amount to deposit: Rs. ");
        account.deposit(amount);
        System.out.printf("Deposit successful. Updated balance: Rs. %.2f%n",
                account.checkBalance());
    }

    private static void performWithdrawal() throws BankingException {
        Account account = getAccountFromUser();
        double amount = readDouble("Enter amount to withdraw: Rs. ");
        account.withdraw(amount);
        System.out.printf("Withdrawal successful. Updated balance: Rs. %.2f%n",
                account.checkBalance());
    }

    private static void checkBalance() throws BankingException {
        Account account = getAccountFromUser();
        System.out.printf("Available balance: Rs. %.2f%n", account.checkBalance());
    }

    private static void displayAccount() throws BankingException {
        Account account = getAccountFromUser();
        System.out.println("\\nAccount type: " + account);
        account.displayDetails();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (Double.isNaN(value) || Double.isInfinite(value)) {
                    System.out.println("Please enter a valid amount.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numeric amount.");
            }
        }
    }
}
