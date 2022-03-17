package io.github.morbidreich.airform.service.task;

import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.entity.tasks.Task;
import io.github.morbidreich.airform.repository.BaseFormRepo;
import io.github.morbidreich.airform.service.BaseFormService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewTaskService {

	BaseFormRepo baseFormrepo;

	public NewTaskService(BaseFormRepo baseFormrepo) {
		this.baseFormrepo = baseFormrepo;
	}

	public Optional<Task> createNewTask(String employeeId, long formId) {

		Optional<BaseForm> formOptional = baseFormrepo.findById(formId);
		if (!formOptional.isPresent()) {
			return Optional.empty();
		}
		else {
			Task task = new Task();
			task.setEmployeeId(employeeId);
			task.setForm(formOptional.get());
			return Optional.of(task);
		}
	}
}
