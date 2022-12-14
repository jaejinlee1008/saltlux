package sampling;

import javax.swing.JOptionPane;

class ThreadEx_06_1 extends Thread
{
	@Override
	public void run() {
		int i=10;
		
		while(i!=0 && !isInterrupted())
		{
			System.out.println(i--); // 출력 후 i 값 1감소
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println("카운트 종료");
	}
}

public class ThreadEx_06 {
	public static void main(String[] args) {
		Thread t = new ThreadEx_06_1();
		t.start();
		
		String data = JOptionPane.showInputDialog("값을 입력하세요!");
		System.out.println(data);
		
		t.interrupt();
	}
}
