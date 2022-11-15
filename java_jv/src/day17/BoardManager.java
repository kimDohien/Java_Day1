package day17;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class BoardManager {
	//번호,제목,내용,작성자,작성일,조회수
	private static int count=0;
	private int num;
	private int views;
	private Date date ;
	
	public BoardManager(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
		++count;
		num = count;
	}
	public BoardManager(int num) {
		this.num=num;
	}


	private String title, content, writer;
	
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}


	public String print() {
		return "---------------------\n"
				+"번호 : "+num+ "\n"
				+"제목 : "+ title+ "\n"
				+"내용 : "+content+ "\n"
				+"작성자 : "+writer+ "\n"
				+"조회수 : "+views+ "\n"
				+"작성일 : "+getDate()+ "\n"
				+"---------------------";
	}
	
	@Override
	public String toString() {
		return num + " , "+title + " , "+ writer+" , "+ views+" , "+getDate();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			//obj가 Integer로 클래스 변환이 가능하면 게시글 번호와 obj를 비교
		if(obj instanceof Integer) {	
			if(num == (Integer)obj) {
				return true;
				}
			}
		//Integer,BoardManager 클래스가 아니거나 게시글 번호가 다른경우
		return false;//다르거나 형변환 할수없으면 리턴 false로
		}
		BoardManager other = (BoardManager) obj;
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
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
		
	}
	public void updateViews() {
		views++;
		
	}
	
	
}
	
	