package springIoc.sample4;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractDay {

	public abstract String dayInfo();

	public static AbstractDay getInstance() {
		// 오늘날짜의 요일을 알아보아요!
		GregorianCalendar cal = new GregorianCalendar();

		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 해당 날짜에 대한 요일을 숫자로 알려줘요! 1 -> 일요일, 2 -> 월요일, 3 -> 화요일

		AbstractDay my_day = null;
		switch (day) {
			case 1:
				my_day = new Sunday();
				break;
			case 2:
				my_day = new Monday();
				break;			
			case 3:
				my_day = new Tuesday();
				break;							
		}		
		return my_day;
	}
}
