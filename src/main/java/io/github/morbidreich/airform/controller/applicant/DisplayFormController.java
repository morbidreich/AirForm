package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.FormDisplayPathResolver;
import io.github.morbidreich.airform.service.FormReadOnlyPathResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/applicant/applications")
public class DisplayFormController {

	private final FormReadOnlyPathResolver formReadOnlyPathResolver;
	private final FormDisplayPathResolver formDisplayPathResolver;
	private final BaseFormService baseFormService;

	public DisplayFormController(FormReadOnlyPathResolver formReadOnlyPathResolver, FormDisplayPathResolver formDisplayPathResolver, BaseFormService baseFormService) {
		this.formReadOnlyPathResolver = formReadOnlyPathResolver;
		this.formDisplayPathResolver = formDisplayPathResolver;
		this.baseFormService = baseFormService;
	}

	@GetMapping("display/{id}")
	public String displayFormReadOnly(@PathVariable long id, Model model) {
		Optional<BaseForm> form = baseFormService.findById(id);

		if (form.isPresent()) {
			BaseForm baseForm = form.get();
			boolean readOnly = baseFormService.isReadOnly(baseForm);
			model.addAttribute("form", form.get());
			model.addAttribute("readOnly", readOnly);
			return formDisplayPathResolver.getPath(form.get().getFormType());
		}
		return "error/404";
	}
}
