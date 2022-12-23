package db.day1;

import java.sql.*;
import java.util.ArrayList;

public class StudentDB {
	private Connection con ;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//연결 생성자
	public StudentDB(String url, String id, String pw) throws Exception{
		connect(url, id, pw);
		stmt = con.createStatement();
	}
	
	//연결 메소드
	private void connect(String url, String id, String pw) throws Exception  {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("[DB 연결 성공]");
	}
	
	public ArrayList<Student1> selectAllStudent() throws SQLException {
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
	public void insertStudent( String st_num, String st_name, int st_semester,
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
