package jaeseong.toby.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	//private SimpleConnectionMaker scm;
	private ConnectionMaker cm;	//readonly
	
//	public UserDAO(ConnectionMaker cm) {
//		//scm = new SimpleConnectionMaker();
//		//Connection c = scm.makeNewConnection();
//				
//		this.cm = cm;
//	}
	
	public void setConnectionMaker(ConnectionMaker cm) {
		this.cm = cm;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {

		Connection c = cm.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {

		Connection c = cm.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("select * from users where id=?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}


}
