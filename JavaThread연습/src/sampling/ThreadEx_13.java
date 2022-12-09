package sampling;

class Common{
	public Common() {
	}
	
	public synchronized void showName()
	{
		
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		notify();
		try {
			wait();
		} catch (Exception e) {
		}
	}
	
	
}

class ThreadEx_13_1 implements Runnable{
	
	Common c = new Common();
	
	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			c.showName();
		}
	}
}


public class ThreadEx_13 {
	public static void main(String[] args) {
		
		ThreadEx_13_1 r = new ThreadEx_13_1();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		for(int i=0;i<10;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
	}
}
