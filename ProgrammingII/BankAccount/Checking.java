package bankAccount;

public class Checking extends BankAccount{
	public Checking(double balance) {
		super(balance);
	}
	public void writeACheck(double amount) {
		this.balance-=amount+1;
	}
}
