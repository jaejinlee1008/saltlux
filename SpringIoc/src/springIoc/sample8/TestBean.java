package springIoc.sample8;

public class TestBean {
	private DataBean data1;
	private DataBean data2;
	
	public TestBean() {
		System.out.println("TestBean default 생성자 호출");
	}

	public DataBean getData1() {
		return data1;
	}

	public void setData1(DataBean data1) {
		this.data1 = data1;
		System.out.println("setter 1 호출");
	}

	public DataBean getData2() {
		return data2;
	}

	public void setData2(DataBean data2) {
		this.data2 = data2;
		System.out.println("setter 2 호출");
	}
	
	
}
