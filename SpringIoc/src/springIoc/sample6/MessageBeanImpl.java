package springIoc.sample6;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private String phone;
	private Output output;
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl default 생성자 호출");
	}
	
	public MessageBeanImpl(String name) {
		this.name=name;
		System.out.println("MessageBeanImpl default 생성자 호출 - " + name);
	}
	
	
	
	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("setphone setter 호출");
	}

	public void setOutput(Output output) {
		this.output = output;
		System.out.println("setoutput setter 호출");
	}

	@Override
	public void sayHello() {
		String msg = name + " : " + phone;
		
		try {
			output.print(msg);
			System.out.println("메세지출력종료");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
