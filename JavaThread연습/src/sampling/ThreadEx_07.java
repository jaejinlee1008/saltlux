package sampling;

class ThreadEx_07_1 implements Runnable{
	@Override
	public void run() {
		while(true)
		{
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}
}

public class ThreadEx_07 {
	
	public static void main(String[] args) {
		
		Runnable r = new ThreadEx_07_1();
		Thread t1 = new Thread(r,"*"); //2번째 인자 thread의 이름
		Thread t2 = new Thread(r,"**"); 
		Thread t3 = new Thread(r,"***"); 
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			t1.suspend();              //t1을 일시정지
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(2000);
			t1.resume();
			Thread.sleep(2000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
		} catch (Exception e) {
			
		}
		
	}
}
