package io.github.morbidreich.airform.controller;

import io.github.morbidreich.airform.dto.UserDto;
import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.repository.UserRepo;
import io.github.morbidreich.airform.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class CreateAccountController {

	UserRepo userRepo;
	UserService userService;

	public CreateAccountController(UserRepo userRepo, UserService userService) {
		this.userRepo = userRepo;
		this.userService = userService;
	}

	@GetMapping("/create-account")
	public String createAccount(Model model) {
		model.addAttribute("user", new User());

		return "create-user";
	}

	@PostMapping("/create-user")
	public String createUser(@ModelAttribute User user, Model model) {
		// TODO form validation
		System.out.println(user);

		if (userRepo.findByUsername(user.getUsername()).isPresent())
			return "redirect:/create-user-error";
		else {
			user.setRoles("ROLE_APPLICANT");
			userRepo.save(user);
			model.addAttribute("user", user);

			return "redirect:/create-user-success";
		}
	}

	@GetMapping("/create-user-success")
	public String userCreated() {

		return "create-user-success";
	}

	@GetMapping("/create-user-error")
	public String userCreationError() {

		return "create-user-error";
	}

	// When user gets created account is by default inactive, and have to
	// be activated by admin. Since that's WIP version of application
	// there's possibility to activate account by user himself

	@GetMapping("/cheat-activation/{username}")
	public String cheatActivation(@PathVariable String username, Authentication authentication) {

		//if (authentication.isAuthenticated())
			userService.activateUser(username);

		return "redirect:/";
	}
}
