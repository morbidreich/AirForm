package io.github.morbidreich.airform.controller;

import io.github.morbidreich.airform.entity.ProbingForm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

	@GetMapping("")
	public String applicantHomepage(Authentication authentication, Model model) {
		model.addAttribute("authObject", authentication);

		return "applicant-home.html";
	}

	@GetMapping("/applications")
	public String getUserApplications() {
		return "applicant-applications";
	}

	@GetMapping("/probing-form")
	public String getProbingForm(Model model) {
		model.addAttribute("form", new ProbingForm());
		return "asm-forms/stratospheric-baloon-form";
	}

	@PostMapping("/probing-form-save")
	public String saveProbingForm(@ModelAttribute ProbingForm form) {
		//save form to database
		System.out.println(form.getEmail());
		System.out.println(form.getName());
		System.out.println(form.getMainDateTime());
		System.out.println(form.getBackupDateTime());

		return "redirect:/applicant";
	}

//	@GetMapping("/user-details")
//	public String applicantForm(Authentication authentication) {
//
//		System.out.println(authentication.getPrincipal());
//		return "applicant-form.html";
//	}
}
