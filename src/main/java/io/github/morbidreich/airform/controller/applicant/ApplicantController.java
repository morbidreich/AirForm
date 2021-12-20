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

	BaseFormService baseFormService;

	public ApplicantController(BaseFormService baseFormService) {
		this.baseFormService = baseFormService;
	}

	@GetMapping("")
	public String applicantHomepage(Authentication authentication, Model model) {
		model.addAttribute("authentication", authentication);
		model.addAttribute("applicationsCount",
				  baseFormService.countAllByApplicantUsername(authentication.getName()));

		return "applicant-home";
	}

	@GetMapping("/applications")
	public String getUserApplications(Authentication authentication, Model model) {

		List<BaseForm> formList = baseFormService.getAllUserForms(authentication.getName());
		model.addAttribute("authentication", authentication);
		model.addAttribute("formList", formList);

		return "applicant-applications";
	}


}
