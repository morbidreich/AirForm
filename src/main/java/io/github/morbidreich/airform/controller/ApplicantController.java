package io.github.morbidreich.airform.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;

@Controller
public class ApplicantController {
	@GetMapping("/applicant")
	public String applicantHomepage(Authentication authentication, Model model) {
		model.addAttribute("authObject", authentication);

		return "applicant-home.html";
	}

//	@GetMapping("/user-details")
//	public String applicantForm(Authentication authentication) {
//
//		System.out.println(authentication.getPrincipal());
//		return "applicant-form.html";
//	}
}
