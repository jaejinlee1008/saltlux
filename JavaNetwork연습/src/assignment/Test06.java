package assignment;

class Months{
	public int getDays(int months)
	{
		int days=0;
		switch (months)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:	
			days=31;
			break;
		case 2:
			days=28;
			break;
		case 9:
		case 4:
		case 6:
		case 11:
			days=30;
			break;
		default:
		}
		return days;
	}
}

public class Test06 {
	public static void main(String[] args) {
		if(args[1]!=null)
		{
			System.out.println("다시 입력해 주세요");
		}
		int day;
		Months m = new Months();
		
		day = m.getDays(Integer.parseInt(args[0]));
		if(day==0)
		{
			System.out.println("입력된 값이 잘못 되었습니다.");
		}else
		{
			System.out.println("입력받은월 : " + Integer.parseInt(args[0]));
			System.out.println("마지막일자 : " + day);
		}
		
	}
}
