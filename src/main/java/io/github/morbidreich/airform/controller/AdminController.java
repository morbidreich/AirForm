package io.github.morbidreich.airform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/admin")
	public String adminHomepage() {
		return "admin-home.html";
	}
}
