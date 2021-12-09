package io.github.morbidreich.airform.controller;

import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Controller
public class CreateAccountController {

	UserRepo userRepo;

	public CreateAccountController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@PostMapping("/create-user")
	public String createUser(@RequestParam String username,
	                         @RequestParam String pass1,
	                         @RequestParam String pass2,
	                         @RequestParam String email) {

		// TODO form validation

		User user = new User(username, pass1, email, false, "ROLE_APPLICANT");
		Long newUserId = userRepo.save(user).getId();

		String uri = UriComponentsBuilder
				  .fromPath("/create-user-succes")
				  .queryParam("id", newUserId)
				  .build().toString();
		return "redirect:" + uri;
	}

	@GetMapping("/create-user-succes")
	public String userCreated(@RequestParam Long id, Model model) {
		model.addAttribute("id", id);
		return "create-user-succes";
	}

	// When user gets created account is by default inactive, and have to
	// be activated by admin. Since that's WIP version of application
	// there's possibility to activate account by user himself
	@GetMapping("/cheat-activation")
	public String cheatActivation(@RequestParam Long id) {

		Optional<User> u = userRepo.findById(id);
		if (u.isPresent()) {
			u.get().setActive(true);
			userRepo.save(u.get());
		}
		return "redirect:/";
	}
}
