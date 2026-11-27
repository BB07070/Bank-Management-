import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Composition: a Bank owns and manages a collection of Account objects.
    private final List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) throws BankingException {
        if (findAccount(account.getAccountNumber()) != null) {
            throw new BankingException("An account with this number already exists.");
        }
        accounts.add(account);
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts have been created yet.");
            return;
        }

        for (Account account : accounts) {
            System.out.println("------------------------------");
            System.out.println(account);
            account.displayDetails();
        }
    }

    public boolean isEmpty() {
        return accounts.isEmpty();
    }
}
