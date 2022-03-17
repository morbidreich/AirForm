package io.github.morbidreich.airform.controller.employee;

import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.tasks.Task;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.UserService;
import io.github.morbidreich.airform.service.task.NewTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class CreateTaskController {

	Logger logger = LoggerFactory.getLogger(CreateTaskController.class);

	private final NewTaskService newTaskService;
	private final UserService userService;
	private final BaseFormService baseFormService;

	public CreateTaskController(NewTaskService newTaskService, UserService userService, BaseFormService baseFormService) {
		this.newTaskService = newTaskService;
		this.userService = userService;
		this.baseFormService = baseFormService;
	}

	//TODO add check to
	@GetMapping("/new-task/{formId}")
	public String createTask(@PathVariable long formId, Model model, Authentication authentication) {


		Optional<Task> taskOptional = newTaskService.createNewTask(authentication.getName(), formId);
		if (taskOptional.isPresent()) {
			boolean isStatusChanged = baseFormService.setFormStatus(formId, FormStatus.PROCESSING);
			logger.info("status changed? " + isStatusChanged);
			model.addAttribute("task", taskOptional.get());
			return "employee/task";
		}
		else return "error/404";
	}
}
