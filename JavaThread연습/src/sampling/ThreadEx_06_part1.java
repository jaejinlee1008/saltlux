package sampling;

import javax.swing.JOptionPane;

class ThreadEx_06_1_part1 extends Thread
{
	@Override
	public void run() {
		int i=10;
		
		while(i!=0 && !isInterrupted())
		{
			System.out.println(i--); // 출력 후 i 값 1감소
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) { //interrupt 발생시 catch문을 실행시키고 interrupt 발생 흔적을 지운다.
				System.out.println("자는 중에 interrupt 발생");
				interrupt();
			}
		}
		System.out.println("카운트 종료");
	}
}

public class ThreadEx_06_part1 {
	public static void main(String[] args) {
		Thread t = new ThreadEx_06_1_part1();
		t.start();
		
		String data = JOptionPane.showInputDialog("값을 입력하세요!");
		System.out.println(data);
		
		t.interrupt(); //만약 interrupt를 걸었는데 이때 해당 thread가 sleep상태이면 exception이 실행됨
	}
}

