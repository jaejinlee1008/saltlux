package sampling;


class ThreadEx_11_1 extends Thread{
	
	// 상수 필드는 관용적으로 대문자 사용, snake case(변수명에 밑줄 이용)이용
	final static int MAX_MEMORY=1000;
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
			System.out.println("남은 메모리량 + " + freeMemory());
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
		
	}
}
