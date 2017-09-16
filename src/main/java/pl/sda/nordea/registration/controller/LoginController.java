package pl.sda.nordea.registration.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String mainUser() {
		return "user/userOptions";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public void loginPost(@RequestParam("username") long userId,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				response.sendRedirect("../index");
}

	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();

	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addObject("username", userDetail.getUsername());
	  }

	  model.setViewName("403");
	  return model;

	}
}
