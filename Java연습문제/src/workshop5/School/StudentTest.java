package workshop5.School;

class Student{
	String name;
	int age;
	int height;
	int weight;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}

public class StudentTest {
	public static void main(String[] args) {
		Student studentArray[]=new Student[3];
		int ageSum=0;
		int heightSum=0;
		int weightSum=0;
		studentArray[0]=new Student("홍길동",15,171,81);
		studentArray[1]=new Student("한사람",13,183,72);
		studentArray[2]=new Student("임걱정",16,175,65);
		System.out.println("이름     나이   신장   몸무게");
		for(int i=0;i<3;i++)
		{
			System.out.printf("%s %5d %5d %5d\n",studentArray[i].getName(),studentArray[i].getAge(),studentArray[i].getHeight(),studentArray[i].getWeight());
			ageSum+=studentArray[i].getAge();
			heightSum+=studentArray[i].getHeight();
			weightSum+=studentArray[i].getWeight();
		}
		System.out.printf("나이의 평균 : %.2f\n",(ageSum/3.0));
		System.out.printf("신장의 평균 : %.2f\n",(heightSum/3.0));
		System.out.printf("몸무게의 평균 : %.2f\n",(weightSum/3.0));
	}
}
