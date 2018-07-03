package jaeseong.toby.spring;

public class DAOFactory {
	public UserDAO userDao() {
		return new UserDAO(connectionMaker());
	}
	
	// if we have many dao, we divide method.
	public ConnectionMaker connectionMaker() {
		return new NUserDAO();
	}
}
