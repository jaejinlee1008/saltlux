package springIoc.anno.sample1;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood") //default bean id : myFoodMgr
public class MyFoodMgr {
	
	@Autowired
	@Qualifier(value="hateFood")
	private Food favoriteFood;
	
	@Autowired
	private Food hateFood;
	
	public MyFoodMgr() {
		System.out.println("default 생성자 호출");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return favoriteFood + "," + hateFood;
		
	}
}
