package io.github.morbidreich.airform.repository;

import io.github.morbidreich.airform.entity.BaseForm;
import io.github.morbidreich.airform.entity.FormStatus;
import io.github.morbidreich.airform.entity.FormType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseFormRepo extends CrudRepository<BaseForm, Long> {
	// used by applicant
	public int countAllByApplicantUsername(String applicantUsername);
	public List<BaseForm> findAllByApplicantUsername(String applicantUsername);
	public List<BaseForm> findAllByApplicantUsernameAndFormStatus(String applicantUsername, FormStatus formStatus);

	// used by employee
	public List<BaseForm> findAllByFormStatus(FormStatus formStatus);
	public List<BaseForm> findAllByFormType(FormType formType);
}