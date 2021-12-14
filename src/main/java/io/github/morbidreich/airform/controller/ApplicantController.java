package io.github.morbidreich.airform.controller;

import io.github.morbidreich.airform.dto.ProbingFormDto;
import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.ProbingFormService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

	ProbingFormService probingFormService;
	BaseFormService baseFormService;

	public ApplicantController(ProbingFormService probingFormService, BaseFormService baseFormService) {
		this.probingFormService = probingFormService;
		this.baseFormService = baseFormService;
	}

	@GetMapping("")
	public String applicantHomepage(Authentication authentication, Model model) {
		model.addAttribute("authentication", authentication);
		model.addAttribute("applicationsCount",
				  baseFormService.countAllByApplicantUsername(authentication.getName()));

		return "applicant-home.html";
	}

	@GetMapping("/applications")
	public String getUserApplications(Principal principal, Model model) {
		List<BaseForm> formList = baseFormService.getAllUserForms(principal.getName());
		model.addAttribute("formList", formList);

		//List<ProbingForm> probingFormList = probingFormService.findAllByUsername(principal.getName());
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
