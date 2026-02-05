// 3. Write a Java program for a simple banking system. Create the following classes:
// Account - A base class with the following members:
    // - Private field accountNumber (String)
    // - Protected field balance (double)
    // - Public method deposit(double amount) which adds the amount to
    // balance.
    // - Public method getBalance() which returns the current balance.
// SavingsAccount - A subclass of Account with an additional feature:
    // - Protected field interestRate (double)
    // - Public method addInterest() which adds interest to the balance based on
    // interestRate.
// Instantiate a SavingsAccount object, deposit an amount, add interest, and print the balance.

class Account {
    private String accountNumber;
    protected double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    protected double interestRate;

    public SavingsAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        if (interestRate > 0) {
            double interest = balance * interestRate / 100;
            deposit(interest);
        } else {
            System.out.println("Interest rate must be positive.");
        }
    }
}

class Q3 {
    public static void main(String[] args) {
        SavingsAccount mySavings = new SavingsAccount("SA12345", 5.0);
        mySavings.deposit(1000.0);
        System.out.println("Balance before interest: $" + mySavings.getBalance());
        mySavings.addInterest();
        System.out.println("Balance after interest: $" + mySavings.getBalance());
    }
}