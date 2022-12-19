package workshop4.account;

public class AccountTest2 {
	public static void main(String[] args) {
		Account ac[]=new Account[5];
		for(int i=0;i<5;i++)
		{
			ac[i]=new Account(("221-0101-211"+(i+1)),100000,4.5);
			ac[i].accountInfo();
		}
		System.out.println();
		for(int i=0;i<5;i++)
		{
			ac[i].setInterestRate(3.7);
			ac[i].accountInfo();
			System.out.printf(" 이자 : %.1f원",ac[i].calculateInterest());
		}
	}
}
