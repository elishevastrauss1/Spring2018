package bankAccount;

public class Savings extends BankAccount{
	double interest;
	
	public Savings(double balance, double interest) {
		super(balance);
		this.interest = interest;
	}

	public void addInterest() {
		this.balance+=this.balance*this.interest;
	}
}
