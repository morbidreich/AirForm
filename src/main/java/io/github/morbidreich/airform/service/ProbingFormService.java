package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.dto.ProbingFormDto;
import io.github.morbidreich.airform.entity.*;
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

	public void save(ProbingFormDto form) {

		//get form dto from controller
		ProbingForm probingForm = new ProbingForm(form);

		//ERROR ERROR THAT"S WRONG, FIX ASAP ERROR ERROR
		// for now hardcode applicat id as 13L - good old qwe
		//probingForm.setApplicantId(13L);

		//since this is a new form, set formStatus as filed
		probingForm.setFormStatus(FormStatus.FILED);
		probingForm.setFormType(FormType.PROBING);

		//save form to database
		probingFormRepo.save(probingForm);

	}

	// return ProbingFormDto filled with user details if userdetails are present
	public ProbingFormDto prepopulateProbingFormDto(String name) {
		Optional<User> optionalUser = userService.getUser(name);
		if (optionalUser.isPresent() && optionalUser.get().getUserDetails() != null) {
			User user = optionalUser.get();
			UserDetails userDetails = user.getUserDetails();
			ProbingFormDto.Builder b = new ProbingFormDto.Builder();
			return b.withName(userDetails.getName() + " " + userDetails.getSurname())
					  .withPhone(userDetails.getPhone())
					  .withEmail(user.getEmail())
					  .build();
		} else return new ProbingFormDto();
	}

	public List<ProbingForm> findAllByUsername(String name) {
		return probingFormRepo.findAllByApplicantUsername(name);
	}
}
