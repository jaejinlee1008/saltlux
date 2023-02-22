package springIoc.anno.sample1;

public class Food {
	private String foodName;
	private String foodPrice;
	
	public Food() {
		System.out.println("Food default 생성자 호출");
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
		System.out.println("setfoodname setter 호출");
		
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
		System.out.println("setfoodprice setter 호출");
	}
	
	@Override
	public String toString() {
		return foodName + " : " + foodPrice;
	}
	
}
