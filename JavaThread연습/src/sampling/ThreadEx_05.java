package sampling;

class ThreadEx_05_1 extends Thread
{
	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println();
		}
		
		for(int i=0;i<300;i++)
		{
			System.out.print("-");
		}
		System.out.println("Thread 1 종료");
	}
}

class ThreadEx_05_2 extends Thread
{
	@Override
	public void run() {
		for(int i=0;i<300;i++)
		{
			System.out.print("|");
		}
		System.out.println("Thread 2 종료");
	}
}

public class ThreadEx_05 {
	
	public static void main(String[] args) {
		
		Thread t1 = new ThreadEx_05_1();
		Thread t2 = new ThreadEx_05_2();
		
		t1.start();
		t2.start();
		
		/*
		 * try { t1.sleep(2000); //Thread.sleep(2000) 의 의미이다 -> main thread를 2초간 재움
		 * sleep이 static method이기 때문 } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println("main Thread 종료 ");
	}
}
