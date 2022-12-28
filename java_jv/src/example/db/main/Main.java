package example.db.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {
	static MainController mc;
public static void main(String[] args) {
		String resource = "example/db/main/Mybatis-config.xml";
		InputStream inputStream;
		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			try (SqlSession session = sqlSessionFactory.openSession()) {
				MainController mc = new MainController(session);
				mc.run();
				 session.commit();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

