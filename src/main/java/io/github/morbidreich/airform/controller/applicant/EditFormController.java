package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.repository.BaseFormRepo;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.FormEditPathResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/applicant/applications")
public class EditFormController {

	private final BaseFormService baseFormService;
	private final FormEditPathResolver formEditPathResolver;

	public EditFormController(BaseFormService baseFormService, FormEditPathResolver formEditPathResolver) {
		this.baseFormService = baseFormService;
		this.formEditPathResolver = formEditPathResolver;
	}

	@RequestMapping("/edit/{id}")
	public String editForm(@PathVariable long id, Model model, Principal principal) {

		Optional<BaseForm> formOpt = baseFormService.findByIdAndUsername(id, principal.getName());

		if (formOpt.isPresent()) {
			BaseForm form = formOpt.get();
			model.addAttribute("form", form);
			return formEditPathResolver.getPath(form.getFormType());
		}
		return "error/404";
	}
}
