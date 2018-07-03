package jaeseong.toby.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOFactory {
	
	@Bean
	public UserDAO userDao() {
		return new UserDAO(connectionMaker());
	}
	
	// if we have many dao, we divide method.
	@Bean
	public ConnectionMaker connectionMaker() {
		return new NUserDAO();
	}
}
