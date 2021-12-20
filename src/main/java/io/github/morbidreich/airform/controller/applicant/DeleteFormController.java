package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.repository.BaseFormRepo;
import io.github.morbidreich.airform.service.BaseFormService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/applicant/applications")
public class DeleteFormController {

	private final BaseFormService baseFormService;

	public DeleteFormController(BaseFormService baseFormService) {
		this.baseFormService = baseFormService;
	}
	@GetMapping("/delete-form/{id}")
	public String deleteForm(@PathVariable Long id, Authentication authentication) {

		boolean deleted = baseFormService.deleteByIdAndUsername(id, authentication.getName());

		if(deleted)
			return "redirect:/applicant/applications";
		else
			return "redirect:/error/404";
	}
}
