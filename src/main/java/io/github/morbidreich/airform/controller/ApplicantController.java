package io.github.morbidreich.airform.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;

@Controller
public class ApplicantController {
	@GetMapping("/applicant/{id}")
	public String applicantHomepage(@PathVariable("id") long id, Authentication authentication, Model model) {

		System.out.println("logged as applicant id:" + id);
		model.addAttribute("authObject", authentication);

		Field[] fields = authentication.getClass().getFields();

		for (Field f : fields) {
			System.out.println(f.getName());
		}

		return "applicant-home.html";
	}

	@GetMapping("/applicant/details")
	public String applicantForm(Authentication authentication) {

		System.out.println(authentication.getPrincipal());
		return "applicant-form.html";
	}
}
