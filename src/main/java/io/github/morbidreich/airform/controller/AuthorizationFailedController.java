package io.github.morbidreich.airform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationFailedController {

	@GetMapping("/loginfailed")
	public String loginFailed() {
		return "login-failed.html";
	}
}
