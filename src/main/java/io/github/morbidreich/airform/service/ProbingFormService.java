package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.*;
import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.enums.FormType;
import io.github.morbidreich.airform.entity.forms.ProbingForm;
import io.github.morbidreich.airform.repository.ProbingFormRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProbingFormService {

	ProbingFormRepo probingFormRepo;
	UserService userService;

	public ProbingFormService(ProbingFormRepo probingFormRepo, UserService userService) {
		this.probingFormRepo = probingFormRepo;
		this.userService = userService;
	}

	public void save(ProbingForm form) {

		//since this is a new form, set formStatus as filed
		form.setFormStatus(FormStatus.FILED);
		form.setFormType(FormType.PROBING);

		//save form to database
		probingFormRepo.save(form);

	}
	public List<ProbingForm> findAllByUsername(String name) {
		return probingFormRepo.findAllByApplicantUsername(name);
	}
}
