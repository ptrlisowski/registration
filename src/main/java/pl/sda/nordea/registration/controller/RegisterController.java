package pl.sda.nordea.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.sda.nordea.registration.entity.UserRoles;
import pl.sda.nordea.registration.entity.Users;
import pl.sda.nordea.registration.repository.UserRolesRepository;
import pl.sda.nordea.registration.repository.UsersRepository;




@Controller
public class RegisterController {
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UserRolesRepository roleRepository;
	
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String registerUserGet() {
		return "user/register";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registerUserPost(@RequestParam("name") String name, @RequestParam("lastname") String lastName,
			@RequestParam("username") String username, @RequestParam("username") long userId, @RequestParam("birth") String birthDate,
			@RequestParam("phone") String phoneNumber, @RequestParam("pass") String password, ModelMap model) {

		Users u = new Users(userId, username, password, name, lastName, birthDate,
			 phoneNumber);
		
		u.setName(u.getName().toUpperCase());
		u.setLastName(u.getLastName().toUpperCase());

		UserRoles ur = new UserRoles(u.getUsername());

		model.addAttribute("msg", "Zarejestrowano użytkownika");
		model.addAttribute("user", u);
		
usersRepository.save(u);
roleRepository.save(ur);

		return "user/userOptions";
	}
	
}