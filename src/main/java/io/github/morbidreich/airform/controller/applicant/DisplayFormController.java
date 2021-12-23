package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.FormReadOnlyPathResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/applicant/applications")
public class DisplayFormController {

	private final FormReadOnlyPathResolver formReadOnlyPathResolver;
	private final BaseFormService baseFormService;

	public DisplayFormController(FormReadOnlyPathResolver formReadOnlyPathResolver, BaseFormService baseFormService) {
		this.formReadOnlyPathResolver = formReadOnlyPathResolver;
		this.baseFormService = baseFormService;
	}

	@GetMapping("display/{id}")
	public String displayFormReadOnly(@PathVariable long id, Model model) {
		Optional<BaseForm> form = baseFormService.findById(id);

		if (form.isPresent()) {
			model.addAttribute("form", form.get());
			return formReadOnlyPathResolver.getPath(form.get().getFormType());
		}
		else
			return "";
	}
}
