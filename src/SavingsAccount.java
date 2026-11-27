public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 4.0;

    public SavingsAccount(String accountNumber, String accountHolder, double openingBalance)
            throws BankingException {
        super(accountNumber, accountHolder, openingBalance);
    }

    @Override
    public double calculateInterest() {
        return checkBalance() * INTEREST_RATE / 100.0;
    }

    @Override
    public String toString() {
        return "Savings Account";
    }
}
