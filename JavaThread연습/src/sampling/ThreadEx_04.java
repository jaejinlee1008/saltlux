package sampling;

public class ThreadEx_04 implements Runnable{
	
	// field
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx_04());
		t.setDaemon(true); //자신을 만든 Thread의 보조 Thread가 된다. 여기선 main thread의 보조
		
		t.start();
		
		for(int i=0;i<10;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
			if(i==5)
			{
				autoSave=true;
			}
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//Thread를 일정시간동안 재운다.
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(autoSave)
			{
				System.out.println("자동저장");
			}
			
		}
	}
}
