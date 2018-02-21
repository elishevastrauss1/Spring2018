package bankAccount;

import java.util.ArrayList;

public class AccountDriver {

	public static void main(String[] args) {
		BankAccount[] accounts=new BankAccount[3];
		
		accounts[0]=new Savings(1100, .05);
		accounts[0].deposit(100);
		accounts[0].withdraw(200);
		((Savings)accounts[0]).addInterest();
		
		accounts[1]=new Checking(100);
		accounts[1].deposit(50);;
		
		accounts[2]=new Checking(200);
		accounts[2].withdraw(100);
		accounts[2].deposit(75);
		((Checking)accounts[2]).writeACheck(50);
		
		for(int i=0;i<accounts.length && accounts[i] !=null; i++) {
			accounts[i].display();
		}
		System.out.println("ArrayList Results:");
		ArrayList<BankAccount> accounts2=new ArrayList<>();
		accounts2.add(new Savings(1100,.05));
		accounts2.get(0).deposit(100);
		accounts2.get(0).withdraw(200);
		((Savings)accounts2.get(0)).addInterest();
		
		accounts2.add(1, new Checking(100));
		accounts2.get(1).deposit(50);
		
		accounts2.add(2,new Checking(200));
		accounts2.get(2).withdraw(100);
		accounts2.get(2).deposit(75);
		((Checking)accounts2.get(2)).writeACheck(50);
		
		for (BankAccount account:accounts2) {
			account.display();
		}

	}

}
