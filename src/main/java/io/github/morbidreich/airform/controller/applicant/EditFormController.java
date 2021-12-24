package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.FormDisplayPathResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applicant/applications")
public class EditFormController {

	private final BaseFormService baseFormService;
	private final FormDisplayPathResolver formDisplayPathResolver;

	public EditFormController(BaseFormService baseFormService, FormDisplayPathResolver formDisplayPathResolver) {
		this.baseFormService = baseFormService;
		this.formDisplayPathResolver = formDisplayPathResolver;
	}

//	@RequestMapping("/edit/{id}")
//	public String editForm(@PathVariable long id, Model model, Principal principal) {
//
//		Optional<BaseForm> formOpt = baseFormService.findByIdAndUsername(id, principal.getName());
//
//		if (formOpt.isPresent()) {
//			BaseForm form = formOpt.get();
//			model.addAttribute("form", form);
//			return formEditPathResolver.getPath(form.getFormType());
//		}
//		return "error/404";
//	}
}
