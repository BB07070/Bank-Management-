public interface TransactionOperations {
    void deposit(double amount) throws BankingException;
    void withdraw(double amount) throws BankingException;
    double checkBalance();
}
