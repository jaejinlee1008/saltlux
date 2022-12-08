package sampling;


class ThreadEx_08_1 implements Runnable{
	
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	@Override
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					
				}
			}
		}
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped=true;
	}
}

public class ThreadEx_08 {
	public static void main(String[] args) {
		ThreadEx_08_1 r1 = new ThreadEx_08_1();
		ThreadEx_08_1 r2 = new ThreadEx_08_1();
		ThreadEx_08_1 r3 = new ThreadEx_08_1();
		
		Thread t1 = new Thread(r1,"*");
		Thread t2 = new Thread(r2,"**");
		Thread t3 = new Thread(r3,"***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			//첫번째 thread 일시 정지
			r1.suspend(); //thread를 제어하는게 아님. thread가 가지고 있는 runnable 객체의 field 제어
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(2000);
			r1.resume();//동작 안됨 -> 변수 타입 앞에 volatile 붙여서 해결->캐쉬메모리가 아닌 메인 메모리에서 값을 얻어옴
			Thread.sleep(2000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
