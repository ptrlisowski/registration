package pl.sda.nordea.registration.controller;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.sda.nordea.registration.entity.UserDetails;
import pl.sda.nordea.registration.entity.UserRoles;
import pl.sda.nordea.registration.entity.Users;
import pl.sda.nordea.registration.repository.UserDetailsRepository;
import pl.sda.nordea.registration.repository.UserRolesRepository;
import pl.sda.nordea.registration.repository.UsersRepository;

@Controller
public class RegisterController {
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UserRolesRepository roleRepository;

	@Autowired
	UserDetailsRepository udRepository;

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String registerUserGet() {
		return "user/register";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registerUserPost(@RequestParam("name") String name, @RequestParam("lastname") String lastName,
			@RequestParam("username") String userName, @RequestParam("birth") String birthDate,
			@RequestParam("phone") String phoneNumber, @RequestParam("pass") String password, ModelMap model,
			HttpServletRequest request) {

		model.clear();
		request.getSession().removeAttribute("error");

		if (usersRepository.exists(userName) == false) {

			Users u = new Users(userName, password);

			UserDetails ud = new UserDetails(userName, name, lastName, birthDate, phoneNumber);
			ud.setName(ud.getName().toUpperCase());
			ud.setLastName(ud.getLastName().toUpperCase());

			UserRoles ur = new UserRoles(u.getUsername());

			model.addAttribute("msg", "Zarejestrowano użytkownika");
			model.addAttribute("user", ud);

			usersRepository.save(u);
			roleRepository.save(ur);
			udRepository.save(ud);

			return "user/userOptions";

		}

		else {
			model.addAttribute("exists", "Użytkownik już isnieje w bazie");
			return "user/userOptions";
		}

	}
}
