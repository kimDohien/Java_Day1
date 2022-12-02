package day30;

import lombok.Data;

@Data
/*필드 : 게시글번호, 제목, 내용, 작성자
 *게시글 번호는 게시글 등록할때 입력 
 *
 *-getter/setter
 *-toString : 번호, 제목, 작성자 순으로 출력
 *-equals/hashcode : 게시글 번호 이용하여 같다고 판별
 *-print : 게시글 번호, 제목, 작성자,내용 순으로 콘솔에 출력하는 메소드
 *-생성자 
 *	- 생성자(번호) : 번호를 이용하여 게시글 객체 생성
 *	- 생성자(번호,제목,내용,작성자) : 번호,제목,내용, 작성자를 이용하여 게시글 객체 생성
 */
public class Board {//필드
	private String title,contents,writer;
	private int num;
	
	@Override
	public String toString() { //toString
		return "[ " +num + " | " + title + " | "+ writer+" ]";
	}

	public Board(int num, String title, String contents, String writer) { //생성자(번호,제목,내용,작성자)
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.num = num;
	}

	public Board(int num) { // 생성자(번호)
		this.num = num;
	}

	@Override //equals/hashcode(번호)
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
	
	public void print() {
		System.out.println("게시글 번호 : " +num);
		System.out.println("제목 : " +title);
		System.out.println("작성자 : " +writer);
		System.out.println("내용 : " +contents);
	}

	

	public static void update(Board board) {
	
		
	}
	

}
