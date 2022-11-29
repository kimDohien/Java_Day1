package day27;

import lombok.Data;

@Data
public class board {

	private int num;
	private static int count = 0;
	private String title, contents, writer;

	public board(String title, String contents) {
		this.title = title;
		this.contents = contents;
		++count;
		count = num;
	}

	public board(int num) {
		this.num = num;
	}

	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if (obj instanceof Integer) {
				if (num == (Integer) obj) {
					return true;
				}
			}
			return false;
		}
		board other = (board) obj;
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

}
