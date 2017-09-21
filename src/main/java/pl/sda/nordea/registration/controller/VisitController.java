package pl.sda.nordea.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit")
public class VisitController {

	@RequestMapping("/")
	public String visitHome() {
		return "visit/home";
	}
	
}
