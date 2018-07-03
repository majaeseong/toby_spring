package jaeseong.toby.spring;

import java.sql.SQLException;

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
	public String home(Model model) throws ClassNotFoundException, SQLException {
		
		UserDAO dao = new DAOFactory().userDao();
		
		User user = new User();
		user.setId("himan2");
		user.setName("jaeseongeda");
		user.setPassword("himan3");
		
		dao.add(user);
		
		model.addAttribute("first", user.getId()+" add Success");
		
		User user2=dao.get(user.getId());
		
		model.addAttribute("second", user2);
		
		return "home";
	}
	
	
}
