package workshop5.mobile;

class Mobile
{
	String mobileName;
	int batterySize;
	String osType;
	
	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	public int operate(int time)
	{
		while(time>=1)
		{
			time-=1;
			batterySize-=10;
		}
		return batterySize;
	}
	
	public int charge(int time)
	{
		while(time>=1)
		{
			time-=1;
			batterySize+=10;
		}
		return batterySize;
	}
}

class Ltab extends Mobile
{
	public Ltab() {
		// TODO Auto-generated constructor stub
	}
	public Ltab(String mobileName,int batterySize,String osType)
	{
		this.mobileName=mobileName;
		this.batterySize=batterySize;
		this.osType=osType;
	}
}
class Otab extends Mobile
{
	public Otab() {
		// TODO Auto-generated constructor stub
	}
	public Otab(String mobileName,int batterySize,String osType)
	{
		this.mobileName=mobileName;
		this.batterySize=batterySize;
		this.osType=osType;
	}
	
	public int operate(int time)
	{
		while(time>=1)
		{
			time-=1;
			batterySize-=12;
		}
		return batterySize;
	}
	
	public int charge(int time)
	{
		while(time>=1)
		{
			time-=1;
			batterySize+=8;
		}
		return batterySize;
	}
}
public class MobileTest {
	public static void main(String[] args) {
		Ltab l=new Ltab("Ltab",500,"AP-01");
		Otab o=new Otab("Otab",1000,"AND-20");
		System.out.printf("%s %d %s\n",l.mobileName,l.batterySize,l.osType);
		System.out.printf("%s %d %s\n",o.mobileName,o.batterySize,o.osType);
		
		l.charge(10);
		o.charge(10);
		
		System.out.printf("%s %d %s\n",l.mobileName,l.batterySize,l.osType);
		System.out.printf("%s %d %s\n",o.mobileName,o.batterySize,o.osType);
		
		l.operate(5);
		o.operate(5);
		System.out.printf("%s %d %s\n",l.mobileName,l.batterySize,l.osType);
		System.out.printf("%s %d %s\n",o.mobileName,o.batterySize,o.osType);
	}
}
