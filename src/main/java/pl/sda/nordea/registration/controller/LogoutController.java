package pl.sda.nordea.registration.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model) throws ServletException {
		request.logout();
		model.addAttribute("logout", "Wylogowano użytkownika");
		return "user/userOptions";
	}
	
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(ModelMap model, HttpServletRequest request,
//			HttpServletResponse response) throws IOException {

//		request.getSession().removeAttribute("loggedin");
//		request.getSession().removeAttribute("activeUser");
//		
//
//		model.clear();
//		model.addAttribute("msg", "Wylogowano użytkownika");
//		// response.sendRedirect("../index");
//		return "index";
//	}
	
}
