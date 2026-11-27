public class CurrentAccount extends Account {
    private static final double MINIMUM_BALANCE = 1000.0;

    public CurrentAccount(String accountNumber, String accountHolder, double openingBalance)
            throws BankingException {
        super(accountNumber, accountHolder, openingBalance);
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdrawal amount must be greater than zero.");
        }
        if (checkBalance() - amount < MINIMUM_BALANCE) {
            throw new BankingException(
                "Withdrawal denied. Current accounts must maintain Rs. 1000 minimum balance."
            );
        }
        super.withdraw(amount);
    }

    @Override
    public double calculateInterest() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Current Account";
    }
}
