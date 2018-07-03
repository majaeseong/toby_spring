package jaeseong.toby.spring;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model){
		
//		UserDAO dao = new DAOFactory().userDao();
//		
//		User user = new User();
//		user.setId("himan2");
//		user.setName("jaeseongeda");
//		user.setPassword("himan3");
//		
//		dao.add(user);
//		
//		model.addAttribute("first", user.getId()+" add Success");
//		
//		User user2=dao.get(user.getId());
//		
//		model.addAttribute("second", user2);
		
		ApplicationContext context=
				new AnnotationConfigApplicationContext(DAOFactory.class);
		UserDAO dao = context.getBean("userDao", UserDAO.class);
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) throws ClassNotFoundException, SQLException{
		DAOFactory f = new DAOFactory();
		
		UserDAO d1 = f.userDao();
		UserDAO d2 = f.userDao();
		
		System.out.println("d1 : "+d1);
		System.out.println("d2 : "+d2);
		
		ApplicationContext context=
				new AnnotationConfigApplicationContext(DAOFactory.class);
		UserDAO d3 = context.getBean("userDao", UserDAO.class);
		UserDAO d4 = context.getBean("userDao", UserDAO.class);
		
		System.out.println("d3 : "+d3);
		System.out.println("d4 : "+d4);
		
		return "home";
	}
	
	
}
