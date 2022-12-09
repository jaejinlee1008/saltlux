package sampling;


class Account{
	public Account() {
	}
	
	public Account(int balance) {
		super();
		this.balance=balance;
	}
	
	private int balance;
	// synchronized method(동기화 메소드)
	// 이 메소드를 먼저 실행한 Thread가 Lock(monitor) 획득
	public void withraw(int money) {
		
		synchronized (this) {  // 이 블록 안의 부분만 동기화 이 블록안의 구역을 임계영역 Critical Section이라 한다.
			if(balance>=money)
			{
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				balance-=money;
			}else
			{
				System.out.println("잔액 부족");
			}
		}
		
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	public void setBalance(int balance)
	{
		this.balance=balance;
	}
}

class ThreadEx_12_1 implements Runnable
{
	Account acc = new Account(1000);
	
	@Override
	public void run() {
		
		while(acc.getBalance()>0)
		{
			int money = (int)((Math.random()*3)+1)*100;
			acc.withraw(money);
			System.out.println(Thread.currentThread().getName()+"가 뺀 금액 : " + money);
			System.out.println(Thread.currentThread().getName()+"남은 금액 : " + acc.getBalance());
		}
	}
}

public class ThreadEx_12 {
	public static void main(String[] args) {
		ThreadEx_12_1 r = new ThreadEx_12_1();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}
