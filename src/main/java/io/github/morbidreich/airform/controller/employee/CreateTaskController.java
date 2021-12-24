package io.github.morbidreich.airform.controller.employee;

import io.github.morbidreich.airform.entity.tasks.Task;
import io.github.morbidreich.airform.service.task.NewTaskService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class CreateTaskController {

	private final NewTaskService newTaskService;

	public CreateTaskController(NewTaskService newTaskService) {
		this.newTaskService = newTaskService;
	}

	//TODO add check to
	@GetMapping("/new-task/{formId}")
	public String createTask(@PathVariable long formId, Model model, Authentication authentication) {

		Task task = newTaskService.createNewTask(authentication., formId);
		model.addAttribute("task", task);
		return "task";
	}
}
