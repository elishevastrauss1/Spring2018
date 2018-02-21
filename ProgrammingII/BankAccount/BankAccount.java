package bankAccount;

public abstract class BankAccount {
	double balance;
	public BankAccount(double balance) {
		this.balance=balance;
	}
	
	public void deposit(double amount) {
		this.balance=balance+amount;
	}
	
	public void withdraw(double amount) {
		this.balance=balance-amount;
	}
	public void display() {
		if (this instanceof Checking) {
			System.out.printf("Checking account balance = $%.2f", this.balance);
			System.out.println();
		}
		else if(this instanceof Savings) {
			System.out.printf("Savings account balance = $%.2f", this.balance);
			System.out.println();
		}
	}
}
