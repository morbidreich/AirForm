package io.github.morbidreich.airform.controller;

import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.entity.UserDetails;
import io.github.morbidreich.airform.repository.UserRepo;
import io.github.morbidreich.airform.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserDetailsController {

	private UserService userService;

	public UserDetailsController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/details")
	public String editUserDetails(Principal principal, Model model) {


		Optional<User> user = userService.getUser(principal.getName());

		if (user.isPresent()) {
			User u = user.get();
			model.addAttribute("user", user.get());
			UserDetails userDetails = (u.getUserDetails() != null) ? u.getUserDetails() : new UserDetails();
			model.addAttribute("userDetails", userDetails);
			return "user-details-form";
		}
		return "error";
	}

	@PostMapping("/save-details")
	public String saveUserDetails(Authentication authentication, @ModelAttribute UserDetails ud) {

			System.out.println(ud.toString());
			userService.updateUserDetails(authentication.getName(), ud);
		// TODO for now it will work only for applicants
		return "redirect:/applicant";
	}

	@GetMapping("/email-password")
	public String editEmailPassword(Model model, Principal principal) {


		return "email-password-form";
	}

}

