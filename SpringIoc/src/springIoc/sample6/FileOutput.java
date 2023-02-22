package springIoc.sample6;

import java.io.FileWriter;

public class FileOutput implements Output{
	private String filePath;
	
	public FileOutput() {
		System.out.println("FileOutput default 생성자 호출");
	}

	public FileOutput(String filePath) {
		super();
		this.filePath = filePath;
		System.out.println("FileOutput 생성자 호출" + filePath);
	}
	
	
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("setter호출");
	}

	@Override
	public void print(String message) throws Exception {
		// TODO Auto-generated method stub
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
		System.out.println("FileOutput 객체의 print() method 호출");
	}
	
}
