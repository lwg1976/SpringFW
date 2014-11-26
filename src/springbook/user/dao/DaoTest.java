package springbook.user.dao;

import java.sql.SQLException;

public class DaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DUserDao dao = new DUserDao();
		
		User user = new User();
		
		user.setId("testId4");
		user.setName("testName4");
		user.setPassword("testPassword4");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");
	}
}
