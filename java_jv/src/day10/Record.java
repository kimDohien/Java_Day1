package day10;

public class Record {
	//기록을 저장하기 위해 record 클래스 만듬.
	private int count;
	private String name;
	
	public Record(int count, String name) {
		super();
		this.count = count;
		this.name = name;
	}
	
	public void print() {
		System.out.println(name + " : "+ count);
	}
	
	public int getCount() {
		return count;
	}

}
