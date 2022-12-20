package workshop7;

import java.text.SimpleDateFormat;
import java.util.Date;

class ConvertDate
{
	public ConvertDate() {
		// TODO Auto-generated constructor stub
	}
	
	public String convert(Date date,int type)
	{
		switch(type)
		{
		case 1:
			SimpleDateFormat df1=new SimpleDateFormat("yyyy-mm-dd");
			return df1.format(date);
		case 2:
			SimpleDateFormat df2=new SimpleDateFormat("yy년 m월 dd일 ");
			return df2.format(date);
			default:
				return "";
		}
	}
}

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();
		ConvertDate cd=new ConvertDate();
		System.out.println(cd.convert(date, 2));
	}
}
