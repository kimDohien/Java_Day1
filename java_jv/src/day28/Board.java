package day28;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Board implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1281344271963794451L;
	private String title, content,writer, category;
	private Date regDate, upDate;
	private int views;
	private int num;
	private static int count =0;
	public static void setCount(int count2) {
		count = count2; //this는 객체를 가르키는데 count는 객체가 아니끼대문에 this뺌
	}
	
	public static int getCount() {
		return count;
	}
	
	
	
	public Board(String title, String content, String writer,String category) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.category = category;
		
		this.num = ++count;
		this.regDate = new Date();
	
	}
	public Board(int num) { //삭제하거나 수정할때 번호 입력해서 하기위해 생성
		this.num = num;
	}
	
	//hashcode,equals할때 num만 같게 하면됨
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	
	
	public String getRegDate() {
		if(regDate == null)
			return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(regDate);
	}
	public String getupDate() {
		if(upDate == null)
			return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(upDate);
	}
	
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
		this.upDate = new Date();
		
	}
	public String toString() {
		return num + ". "+ category + " | " + title +" | "+ getRegDate() + " | "+ views + " | " + writer + " | " ;
	}
	
	public void print() {
		System.out.println("번호 : "+num);
		System.out.println("카테고리 : "+category);
		System.out.println("제목 : "+title);
		System.out.println("작성일 : "+getRegDate());
		if(upDate != null)
			System.out.println("수정일 : " + getupDate());
		System.out.println("조회수 : "+views);
		System.out.println("작성자 : "+writer);
		System.out.println("내용 : "+content);
	}
	
}
