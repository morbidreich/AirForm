package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.entity.UserDetails;
import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.enums.FormType;
import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.repository.BaseFormRepo;
import io.github.morbidreich.airform.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseFormService {
	private final BaseFormRepo baseFormRepo;
	private final UserRepo userRepo;

	public BaseFormService(BaseFormRepo baseFormRepo, UserRepo userRepo) {
		this.baseFormRepo = baseFormRepo;
		this.userRepo = userRepo;
	}

	public Optional<BaseForm> findById(Long id) {
		return baseFormRepo.findById(id);
	}

	public boolean deleteByIdAndUsername(long id, String username) {
		Optional<BaseForm> form = baseFormRepo.findByIdAndApplicantUsername(id, username);
		if (form.isPresent()) {
			baseFormRepo.delete(form.get());
			return true;
		}
		else return false;
	}

	public Optional<BaseForm> findByIdAndUsername(long id, String username) {
		return baseFormRepo.findByIdAndApplicantUsername(id, username);
	}

	public int countAllByApplicantUsername(String applicantUsername) {
		return baseFormRepo.countAllByApplicantUsername(applicantUsername);
	}

	public List<BaseForm> getAllUserForms(String name) {
		return baseFormRepo.findAllByApplicantUsername(name);
	}

	public BaseForm prepopulateForm(BaseForm form, String username) {
		
		Optional<User> userOptional = userRepo.findByUsername(username);
		if (userOptional.isPresent()) {
			User u = userOptional.get();
			form.setApplicantUsername(u.getUsername());
			if (u.getUserDetails() != null) {
				UserDetails ud = u.getUserDetails();
				form.setName(ud.getName() + " " + ud.getSurname());
				form.setPhone(ud.getPhone());
				form.setEmail(u.getEmail());
			}
		}
		return form;
	}

	public List<BaseForm> findAllByStatus(FormStatus formStatus) {
		return baseFormRepo.findAllByFormStatus(formStatus);
	}
	public List<BaseForm> findAllByStatusOrderByApplicationDateTimeAsc(FormStatus formStatus) {
		return baseFormRepo.findAllByFormStatusOrderByApplicationDateTimeAsc(formStatus);
	}
}
