package sampling;


class Shared{
	public synchronized void printName()
	{
		
		try {
			for(int i=0;i<10;i++)
			{
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				notify();
				wait();
			}
		} catch (Exception e) {
			
		}
		notifyAll();
	}
}

class ThreadEx_14_1 implements Runnable{
	
	private Shared shared;
	public ThreadEx_14_1() {
		
	}
	
	public ThreadEx_14_1(Shared shared) {
		super();
		this.shared = shared;
	}
	
	@Override
	public void run() {
		shared.printName();
	}
}


public class ThreadEx_14 {
	public static void main(String[] args) {
		
		Shared shared = new Shared();
		
		
		Thread t1 = new Thread(new ThreadEx_14_1(shared),"첫번째 쓰레드");
		Thread t2 = new Thread(new ThreadEx_14_1(shared),"두번째 쓰레드");
		
		
		
		t1.start();
		t2.start();
		
		
		
	}
}
