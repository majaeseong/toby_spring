package jaeseong.toby.spring;

public class DAOFactory {
	public UserDAO userDao() {
		ConnectionMaker cm = new NUserDAO();
		UserDAO dao = new UserDAO(cm);
		return dao;
	}
}
