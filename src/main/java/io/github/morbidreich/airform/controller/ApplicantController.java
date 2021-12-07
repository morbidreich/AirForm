package io.github.morbidreich.airform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicantController {
	@GetMapping("/applicant")
	public String applicantHomepage() {
		return "applicant-home.html";
	}

	@GetMapping("/applicant-form")
	public String applicantForm() {
		return "applicant-form.html";
	}
}
