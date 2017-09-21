package pl.sda.nordea.registration.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.sda.nordea.registration.repository.UsersRepository;
import pl.sda.nordea.registration.entity.Users;

@RequestMapping("/user")
@Controller
public class LoginController {
	
	@Autowired
	UsersRepository userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainUser() {
		return "user/userOptions";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(){
		
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void loginPost (){
		
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String loginPost (){
//		return "index";
//	}
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public void loginPost(@RequestParam("username") long userId,
//			@RequestParam("username") String username,
//			@RequestParam("password") String password,
//			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.getSession().removeAttribute("error");
//		try {
//			if (username.equals(userRepository.findOne(userId).getUsername())
//					&& password.equals(userRepository.findOne(userId)
//							.getPassword())) {
//
//				request.getSession().setAttribute("loggedin", true);
//				Users u = userRepository.findOne(userId);
//				request.getSession().setAttribute("activeUser", u);
//				response.sendRedirect("../");
//
//			} else {
//				request.getSession().setAttribute("error", "Błędne dane logowania");
//				response.sendRedirect("../user/");
//
//			}
//		} catch (NullPointerException e) {
//			request.getSession().setAttribute("error", "Brak użytkownika w bazie");
//			response.sendRedirect("../user/");
//		}
//	}
	
	

}
