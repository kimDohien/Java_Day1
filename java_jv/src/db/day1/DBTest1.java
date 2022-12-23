package db.day1;

import java.sql.*;
import java.util.ArrayList;

import lombok.Data;

public class DBTest1 {

	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	public static void main(String[] args) {
		Connection con = null;
		/*
		 * mysql : DBMS 종류 localhost : 내부 로컬 주소 -> 프로그램이 실행되는 서버와 DB가 같은 pc에 있는경우 '/'+
		 * 데이터베이스 이름
		 */
		String url = "jdbc:mysql://localhost/university";
		String id = "root"; // DB아이디
		String pw = "root"; // DB 비번 (개인비번..쓰지않도록..주의 but 깃에 안올릴때는 ㄱㅊ)
		con = connect(url, id, pw);
		ArrayList<Student1> list = null;
		
		
		
		try {
			stmt = con.createStatement();
			
//			insertStudent(con,"2022160006","곽두팔",1,"재학","2022160001"); //학생추가
//			updateStudent(con,"2022160001","가나다"); //학생수정
			deleteStudent(con,"2022160008");
			
			list = selectAllStudent(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectClose(con);
	}



	private static void deleteStudent(Connection con, String st_num) throws SQLException{//삭제
		//delete준비
		String sql = "delete from student where st_num =?";
						
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,st_num);
		
		//insert실행
		int count = pstmt.executeUpdate(); //실행을 했을때 몇개의 결과값에 영향을 미쳤는지
		if(count == 0) {
			System.out.println("[삭제 실패]");
		}else {
			System.out.println("[삭제 성공]");
		}
		
	}



	private static void updateStudent(Connection con, String st_num, String st_name) throws SQLException { //수정
	
			//update
			String sql = "update student set st_name =?"+
							"where st_num =?";
							
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,st_name);
			pstmt.setString(2,st_num);
			
			//insert실행
			int count = pstmt.executeUpdate(); //실행을 했을때 몇개의 결과값에 영향을 미쳤는지
			if(count == 0) {
				System.out.println("[수정 실패]");
			}else {
				System.out.println("[수정 성공]");
			}
	}




	// 메소드 만듬
	public static Connection connect(String url, String id, String pw) {
		Connection con = null;
		try {
			// "" 안에있는 이름이 있는지 찾아줌
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, id, pw);
			System.out.println("[연결 성공]");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("[에러: " + e + "]");
		}
		return con;
	}

	// try catch 메소드
	public static void connectClose(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				System.out.println("[연결 해제]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//학생반환 메소드
	public static ArrayList<Student1> selectAllStudent(Connection con) throws SQLException {
		String sql = "select st_num, st_name, st_semester, st_status,st_pr_num from student";
		rs = stmt.executeQuery(sql); //resultSet으로 받아오고
		ArrayList<Student1> list = new ArrayList<Student1>();
		while (rs.next()) { // 속성들을 반복문으로 받아옴
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(3);
			String st_status = rs.getString(4);
			String st_pr_num = rs.getString(5);
			System.out.println(st_num + "," + st_name + "," + st_semester + "," + st_status + "," + st_pr_num);
			Student1 std = new Student1(st_num, st_name, st_semester, st_status,st_pr_num);
			list.add(std);
		}
		return list;
	}

	//insert메소드
	public static void insertStudent(Connection con, String st_num, String st_name, int st_semester,
			String st_status, String st_pr_num) throws SQLException{
		//insert준비
		String sql = "insert into student(st_num, st_name, st_semester,st_status,st_pr_num)"+
						"values(?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,st_num);
		pstmt.setString(2,st_name);
		pstmt.setInt(3,st_semester); //setInt로 해도되고 setString으로 해도상관없 => 숫자는 알아서 변환됨
		pstmt.setString(4,st_status);
		pstmt.setString(5,st_pr_num);
		
		//insert실행
		int count = pstmt.executeUpdate(); //실행을 했을때 몇개의 결과값에 영향을 미쳤는지
		if(count == 0) {
			System.out.println("[추가 실패]");
		}else {
			System.out.println("[추가 성공]");
		}
	
	}
	
}

@Data
class Student1 {
	private String st_num;
	private String st_name;
	private int st_semester;
	private String st_status;
	private String st_pr_num;
	
	public Student1(String st_num, String st_name, int st_semester, String st_status, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_status = st_status;
		this.st_pr_num = st_pr_num;
	}
}
