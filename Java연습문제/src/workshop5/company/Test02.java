package workshop5.company;

class Company
{
	double salary;
	double annualIncome;
	double afterTaxAnnualIncome;
	double bonus;
	double afterTaxBonus;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(double salary) {
		super();
		this.salary = salary;
		this.bonus=salary*0.2*4;
		this.afterTaxAnnualIncome = salary*0.9*12;
		this.afterTaxBonus=bonus*0.945;
		this.annualIncome=salary*12;
		
		
	}
	public double getIncome()
	{
		return annualIncome;
	}
	
	public double getAfterTaxIncome()
	{
		return afterTaxAnnualIncome;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
	public double getAfterTaxBonus()
	{
		return afterTaxBonus;
	}
}

public class Test02 {
	public static void main(String[] args) {
		Company com=new Company(100.0);
		System.out.printf("연 기본급 합 : %.1f 세후: %.1f\n", com.getIncome(),com.getAfterTaxIncome());
		System.out.printf("연 보너스 합 : %.1f 세후: %.1f\n", com.getBonus(),com.getAfterTaxBonus());
		System.out.printf("연 지급액 합 : %.1f\n", (com.getAfterTaxBonus()+com.getAfterTaxIncome()));
		
	}
}
