public abstract class Account implements TransactionOperations {
    private final String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double openingBalance)
            throws BankingException {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new BankingException("Account number cannot be empty.");
        }
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new BankingException("Account holder name cannot be empty.");
        }
        if (openingBalance < 0) {
            throw new BankingException("Opening balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) throws BankingException {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new BankingException("Account holder name cannot be empty.");
        }
        this.accountHolder = accountHolder;
    }

    @Override
    public void deposit(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new BankingException("Insufficient balance.");
        }
        balance -= amount;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.printf("Balance        : Rs. %.2f%n", balance);
        System.out.printf("Interest       : Rs. %.2f%n", calculateInterest());
    }
}
