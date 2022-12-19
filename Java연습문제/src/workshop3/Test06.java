package workshop3;

class Student
{
	String name;
	int Korean;
	int english;
	int math;
	int science;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int Korean,int english,int math, int science)
	{
		this.name=name;
		this.Korean=Korean;
		this.english=english;
		this.math=math;
		this.science=science;
	}
	public double getAvg()
	{
		return (Korean+english+math+science)/4.0;
	}
	public String getGrade()
	{
		switch((int)(getAvg()/10.0))
		{
		case 10:
		case 9:
			return "A";
		case 8:
		case 7:
			return "B";
		case 6:
		case 5:
			return "C";
		case 4:
		case 3:
			return "D";
			default:
				return "F";
		
		}
	}
	public String getName()
	{
		return this.name;
	}
}

public class Test06 {
	public static void main(String[] args) {
		Student s1=new Student("Kim",100,90,95,89);
		Student s2=new Student("Lee",60,70,99,98);
		Student s3=new Student("Park",68,86,60,40);
		
		System.out.println(s1.getName()+" 평균:"+s1.getAvg()+"학점"+s1.getGrade());
		System.out.println(s2.getName()+" 평균:"+s2.getAvg()+"학점"+s2.getGrade());
		System.out.println(s3.getName()+" 평균:"+s3.getAvg()+"학점"+s3.getGrade());
	}
}
