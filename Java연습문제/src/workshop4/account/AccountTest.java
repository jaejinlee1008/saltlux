package workshop4.account;

class Account
{
	String account;
	int balance;
	double interestRate;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String account,int balance,double interestRate)
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
	public int getBalance() {
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
		balance+=money;
	}
	public void withdraw(int money)
	{
		balance-=money;
	}
	public void accountInfo()
	{
		System.out.printf("\n계좌정보: %s 현재잔액:%d 이자율 :%.1f",getAccount(),getBalance(),getInterestRate());
	}
}

public class AccountTest {
	public static void main(String[] args) {
		Account ac=new Account("441-0290-1203",500000,7.3);
		System.out.printf("계좌정보: %s 현재잔액:%d\n",ac.getAccount(),ac.getBalance());
		ac.deposit(20000);
		System.out.printf("계좌정보: %s 현재잔액:%d\n",ac.getAccount(),ac.getBalance());
		System.out.printf("이자:%.1f\n",ac.calculateInterest());
	}
}
