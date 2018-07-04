package jaeseong.toby.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOFactory {
	
	@Bean
	public UserDAO userDao() {
		UserDAO dao = new UserDAO();
		dao.setConnectionMaker(connectionMaker());
		return dao;
	}
	
	// if we have many dao, we divide method.
	@Bean
	public ConnectionMaker connectionMaker() {
		return new NUserDAO();
	}
}
