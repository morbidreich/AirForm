package io.github.morbidreich.airform.service.task;

import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.entity.tasks.Task;
import io.github.morbidreich.airform.repository.BaseFormRepo;
import io.github.morbidreich.airform.service.BaseFormService;
import org.springframework.stereotype.Service;

@Service
public class NewTaskService {

	BaseFormRepo baseFormrepo;

	public NewTaskService(BaseFormRepo baseFormrepo) {
		this.baseFormrepo = baseFormrepo;
	}

	public Task createNewTask(long employeeId, long formId) {
		BaseForm baseForm = baseFormrepo.findById(formId).get();
		if (baseForm.getFormStatus() != FormStatus.FILED)
			throw new FormAlreadyProcessedException();

		Task task = new Task();
		task.setEmployeeId(employeeId);
		//TODO check for isPresent
		task.setForm(baseFormrepo.findById(formId).get());
		return task;
	}
}
