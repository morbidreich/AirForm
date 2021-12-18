package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.entity.forms.ProbingForm;
import io.github.morbidreich.airform.entity.forms.RecreationBaloonForm;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.ProbingFormService;
import io.github.morbidreich.airform.service.RecreationBaloonService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

	RecreationBaloonService recreationBaloonService;
	BaseFormService baseFormService;

	public ApplicantController(BaseFormService baseFormService,
							   RecreationBaloonService recreationBaloonService) {
		this.baseFormService = baseFormService;
		this.recreationBaloonService = recreationBaloonService;
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

		return "applicant-applications";
	}

	@GetMapping("/recreation-baloon-form")
	public String recreationBaloonForm(Model model, Principal principal) {
		RecreationBaloonForm form = new RecreationBaloonForm();
		form = (RecreationBaloonForm) baseFormService.prepopulateForm(form, principal.getName());
		model.addAttribute("form", form);

		return "asm-forms/recreation-baloon-form";
	}

	@PostMapping("/baloon-form-save")
	public String saveBaloonForm(@ModelAttribute RecreationBaloonForm form, Principal principal) {
		form.setApplicantUsername(principal.getName());
		recreationBaloonService.saveNew(form);

		return "redirect:/applicant";
	}
}
