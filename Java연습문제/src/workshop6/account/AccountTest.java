package workshop6.account;

class Account
{
	String account;
	double balance;
	double interestRate;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String account,double balance,double interestRate)
	{
		this.account=account;
		this.balance=balance;
		this.interestRate=interestRate;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getBalance() {
		return balance;
	}
	public double getInterestRate()
	{
		return interestRate;
	}
	public void setInterestRate(double interestRate)
	{
		this.interestRate=interestRate;
	}
	
	public double calculateInterest()
	{
		return balance*(interestRate/100);
	}
	public void deposit(int money)
	{
		try {
			if(money<0)
			{
				throw new Exception("입금 금액 0보다 작음");
			}else
			{
				balance+=money;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("입금 에러");
		}
		
	}
	public void withdraw(int money)
	{
		try {
			if(money>balance)
			{
				throw new Exception("출금 금액 잔고보다 많음");
			}else
			{
				balance-=money;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("출금 에러");
		}
		
	}
	public void accountInfo()
	{
		System.out.printf("계좌정보: %s 현재잔액:%.1f 이자율 :%.1f\n",getAccount(),getBalance(),getInterestRate());
	}
}

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account("441-0290-1203",500000.0,7.3);
		account.accountInfo();
		account.deposit(-10);
		account.withdraw(600000);
		System.out.println("이자 : "+account.calculateInterest());
	}
}
