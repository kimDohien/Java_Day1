package day20;

import lombok.Data;

@Data
public class BookPro {

	//필드 -> 객체를 나타내는 정보
	private String title,author,publish,genre,isbn; //외부에서 접근하지 못하도록 private붙임
	private int price;
	
	//생성자 =>필드 초기화
	public BookPro(String title, String author, String publish, String genre, String isbn, int price) {
		this.title = title;
		this.author = author;
		this.publish = publish;
		this.genre = genre;
		this.isbn = isbn;
		this.price = price;
	}
	
	//메소드 =>기능
	//기본적인 필요 기능 : getter,setter => @Data로 처리 / @Getter,@Setter로 처리 (class 위에)
	//toString 오버라이드 =>도서정보를 간단하게 문자열로 만들기 위해 => @Data,@ToStrin으로 처리
	//equals => 상황에 따라 오버라이딩 하면 됨. => @Data , @EqualsAndHashCode로 처리
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookPro other = (BookPro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
}
