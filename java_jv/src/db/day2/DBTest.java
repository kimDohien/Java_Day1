package db.day2;

import java.sql.*;
import java.util.ArrayList;

import lombok.Data;

public class DBTest {

	Connection con ;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	
	public static void main(String[] args) {
				 DBTest dbTest = new DBTest();    
				 ArrayList<StudentV01> list = new ArrayList<StudentV01>();
				 
				 studentDAOImp studentDao = null; 
				 
		        try{
		        	
		            String url = "jdbc:mysql://localhost/university";
		            String id = "root", pw = "root";
		            dbTest.connect(url,id,pw);
		            System.out.println("[Connect Success]");
		            
		            studentDao =new studentDAOImp(dbTest.con);
		            
		            //-DB연결 완료-
		        
		            //값 불러오기
		            list = studentDao.selectAllStudent();
//		            System.out.println(list); //학생 전체 조회
//		            System.out.println(studentDao.selectStudentBySt_num("2022160001"));	//특정 학생 조회
//		            StudentV01 std = new StudentV01("2022135001","고둘리",1,"재학","2022160001"); //학생추가
//		            if(studentDao.insertStudent(std)) {
//		            	System.out.println("[추가 성공]");
//		            }else {
//		            	System.out.println("!추가 실패!");
//		            }
//		            
//		            if(studentDao.deleteStudent("2022135001")) { //학생삭제
//		            	System.out.println("[삭제 성공]");
//		            }else {
//		            	System.out.println("!삭제 실패!");
//		            }
		            
//		            if(studentDao.updateStudent("2022160001","가소로")) { //학생수정
//		            	System.out.println("[수정 성공]");
//		            }else {
//		            	System.out.println("!수정 실패!");
//		            }
		            
		            
		        }
		        catch(SQLException e){
		            System.out.println("!Connect Fail!");
		        }
		      finally {
		    	  dbTest.closeConnect();
		      }
		            
	}
	
	public void connect(String url, String id, String pw) throws SQLException {
	      con = DriverManager.getConnection(url, id, pw);
	      stmt = con.createStatement(); //고정된 쿼리 이용
	}

	public void closeConnect() {
		try{
            if( con != null && !con.isClosed()){
                con.close();
            }
            if( stmt != null && !stmt.isClosed()){
                stmt.close();
            }
            if( rs != null && !rs.isClosed()){
                rs.close();
            }
            if( pstmt != null && !pstmt.isClosed()){
                pstmt.close();
            }
        }
        catch( SQLException e){
            e.printStackTrace();
        }
    }
	
	
}


@Data
class StudentV01{
		private String st_num;
		private String st_name;
		private int st_semester;
		private String st_status;
		private String st_pr_num;
		
		public StudentV01(String st_num, String st_name, int st_semester, String st_status, String st_pr_num) {
			this.st_num = st_num;
			this.st_name = st_name;
			this.st_semester = st_semester;
			this.st_status = st_status;
			this.st_pr_num = st_pr_num;
		}
}

