package sampling;

class Common{
	public Common() {
	}
	
	private String Name;
	
	public synchronized void showName()
	{
		System.out.println(Name); 
		notify();
		try {
			wait();
		} catch (Exception e) {
		}
	}
	
	public void SetName(String Name) {
		this.Name=Name;
	}
}

class ThreadEx_13_1 implements Runnable{
	
	Common c = new Common();
	
	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			c.SetName(Thread.currentThread().getName());
			c.showName();
		}
	}
}


public class ThreadEx_13 {
	public static void main(String[] args) {
		
		ThreadEx_13_1 r = new ThreadEx_13_1();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		
	}
}
