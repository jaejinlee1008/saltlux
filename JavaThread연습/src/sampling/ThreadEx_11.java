package sampling;

// 이 Thread의 instance를 생성해서 실행하면
// 일정 시간마다 일정량의 메모리 사용량을 감소시킨다.
class ThreadEx_11_1 extends Thread{
	
	// 상수 필드는 관용적으로 대문자 사용, snake case(변수명에 밑줄 이용)이용
	final static int MAX_MEMORY=1000; //static으로 잡아서 instance 없이 class만으로도 사용 가능
	int usedMemory=0;
	
	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				
			}
			gc(); //memory 청소해서 memory용량 확보하는 method
			System.out.println("청소 후 남은 메모리량 = " + freeMemory());
		}
	}
	
	public void gc() {
		usedMemory-=300;
		if(usedMemory<0)
		{
			usedMemory=0;
		}
	}
	
	public int totalMemory() { //전체 메모리량 리턴
		return MAX_MEMORY;
	}
	
	public int freeMemory() {  //현재 가용한 메모리량 리턴
		return MAX_MEMORY-usedMemory;
	}
}

public class ThreadEx_11 {
	public static void main(String[] args) {
		ThreadEx_11_1 t = new ThreadEx_11_1();
		t.setDaemon(true);
		t.start();
		
		int requiredMemory = 0;
		
		for(int i=0;i<20;i++) {
			requiredMemory = ((int)(Math.random()*10))*20; //Math.random->0보다 크거나 작고 1보다 작은 값 리턴
			
			//사용될메모리량이 하숑할 수 있는 메모리 량보다 크거나 전체 메모리량의 60%가 사용될 때 gc를 사용
			if((t.freeMemory()<requiredMemory) || t.freeMemory()<(0.4)*t.totalMemory())
			{
				t.interrupt();
				try {
					t.join(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else
			{
				t.usedMemory+=requiredMemory;
			}
			System.out.println("남은 메모리량 = " + t.freeMemory());
		}
		
	}
}
