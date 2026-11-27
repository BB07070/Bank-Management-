# Banking Management System (Java OOP)

## Project overview

A beginner-friendly, menu-driven console application that demonstrates core Java OOP concepts. It supports creating savings/current accounts, depositing, withdrawing, checking balances, and displaying account details.

## Requirements

* JDK 17 or later (JDK 8+ should also work)
* Visual Studio Code with the Java Extension Pack, or another Java IDE
* No database or external library is required

## Files

* `Account.java` – abstract parent class; encapsulated account data and common operations
* `SavingsAccount.java` – savings account subclass with 4% illustrative interest calculation
* `CurrentAccount.java` – current account subclass with a minimum balance rule
* `TransactionOperations.java` – transaction interface
* `BankingException.java` – custom checked exception
* `Bank.java` – manages account objects using composition
* `Main.java` – menu and user interaction

## Compile and run (from the project folder)

```bash
javac -d out src/\*.java
java -cp out Main
```

On Windows PowerShell or Command Prompt, the same commands work if `javac` and `java` are on PATH.

## OOP concepts demonstrated

1. Encapsulation: private fields in `Account`, accessed through methods.
2. Inheritance: `SavingsAccount` and `CurrentAccount` extend `Account`.
3. Polymorphism: `Account` references hold child objects; `calculateInterest()` is overridden.
4. Interface: `Account` implements `TransactionOperations`.
5. Composition: `Bank` contains and manages a list of `Account` objects.
6. Exception handling: custom `BankingException` and input validation.



