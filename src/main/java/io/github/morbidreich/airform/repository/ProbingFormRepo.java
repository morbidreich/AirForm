package io.github.morbidreich.airform.repository;

import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.forms.ProbingForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProbingFormRepo extends CrudRepository<ProbingForm, Long> {
	List<ProbingForm> findAllByApplicantUsername(String applicantUsername);
	List<ProbingForm> findAllByFormStatus(FormStatus formStatus);
}
