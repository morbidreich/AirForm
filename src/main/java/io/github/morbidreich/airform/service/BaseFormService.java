package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.repository.BaseFormRepo;
import org.springframework.stereotype.Service;

@Service
public class BaseFormService {
	private BaseFormRepo baseFormRepo;

	public BaseFormService(BaseFormRepo baseFormRepo) {
		this.baseFormRepo = baseFormRepo;
	}

	public int countAllByApplicantUsername(String applicantUsername) {
		return baseFormRepo.countAllByApplicantUsername(applicantUsername);
	}
}
