package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.entity.UserDetails;
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
	private BaseFormRepo baseFormRepo;

	@Autowired
	private UserRepo userRepo;

	public BaseFormService(BaseFormRepo baseFormRepo) {
		this.baseFormRepo = baseFormRepo;
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
}
