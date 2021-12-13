package io.github.morbidreich.airform.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Authentication authentication, Model model) {

		if (authentication!= null && authentication.isAuthenticated()) {
			model.addAttribute("isAuth", authentication.isAuthenticated());
			model.addAttribute("authObject", authentication);
		}
		else
			model.addAttribute("isAuth", false);

		return "index.html";
	}
}
