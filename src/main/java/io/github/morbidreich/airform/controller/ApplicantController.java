package io.github.morbidreich.airform.controller;

import io.github.morbidreich.airform.dto.ProbingFormDto;
import io.github.morbidreich.airform.entity.ProbingForm;
import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.repository.UserRepo;
import io.github.morbidreich.airform.service.ProbingFormService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

	ProbingFormService probingFormService;


	public ApplicantController(ProbingFormService probingFormService) {
		this.probingFormService = probingFormService;
	}

	@GetMapping("")
	public String applicantHomepage(Authentication authentication, Model model) {
		model.addAttribute("authObject", authentication);

		return "applicant-home.html";
	}

	@GetMapping("/applications")
	public String getUserApplications(Principal principal, Model model) {
		List<ProbingForm> probingFormList = probingFormService.findAllByUsername(principal.getName());
		model.addAttribute("probingFormList", probingFormList);
		return "applicant-applications";
	}

	@GetMapping("/probing-form")
	public String getProbingForm(Model model, Principal principal) {
		//prepopulate probing form dto with user details if present
		ProbingFormDto probingFormDto = probingFormService.prepopulateProbingFormDto(principal.getName());
		model.addAttribute("form", probingFormDto);

		return "asm-forms/stratospheric-baloon-form";
	}

	@PostMapping("/probing-form-save")
	public String saveProbingForm(@ModelAttribute ProbingFormDto form, Principal principal) {
		form.setApplicantUsername(principal.getName());
		System.out.println(form);
		probingFormService.save(form);

		return "redirect:/applicant";
	}

//	@GetMapping("/user-details")
//	public String applicantForm(Authentication authentication) {
//
//		System.out.println(authentication.getPrincipal());
//		return "applicant-form.html";
//	}
}
