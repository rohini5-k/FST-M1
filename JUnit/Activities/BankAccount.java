package session1;

public class BankAccount {
	
	    private int balance;
	    public BankAccount(int initialBalance) {
	        balance = initialBalance;
	    }

	    // Add method to calculate
	    // balance amount after withdrawal
	    public int withdraw(int amount) {
	        if (balance < amount) {
	            throw new NotEnoughFundsException(amount, balance);
	        }
	        balance -= amount;
	        return balance;
	    }
	}

