package io.github.morbidreich.airform.controller;

import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.service.BaseFormService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

	private final BaseFormService baseFormService;

	public EmployeeController(BaseFormService baseFormService) {
		this.baseFormService = baseFormService;
	}

	@GetMapping("/employee")
	public String employeeHomescreen(Authentication authentication, Model model) {
		List<BaseForm> formList = baseFormService.findAllByStatus(FormStatus.FILED);
		model.addAttribute("formList", formList);
		model.addAttribute("authentication", authentication);
		return "employee/home";
	}


}
