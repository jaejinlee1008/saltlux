package sampling;

class ThreadEx_10_1 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<100;i++)
		{
			System.out.print("-");
		}
	}
}

class ThreadEx_10_2 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<100;i++)
		{
			System.out.print("|");
		}
	}
}

public class ThreadEx_10 {

	public static void main(String[] args) {
		long startTime=0;
		
		Thread t1=new ThreadEx_10_1();
		Thread t2=new ThreadEx_10_2();
			
		t1.start();
		t2.start();
		
		startTime=System.currentTimeMillis(); //현재시간을 숫자로 표현
		
		try {
			t1.join(); //main thread를 t1 thread가 일을 끝낼 때 까지 멈춘다. t1을 우선순위를 줘서 join시킨다
			t2.join();
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("소요시간 : " + (System.currentTimeMillis()-startTime));
	}
}
