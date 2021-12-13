package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.entity.UserDetails;
import io.github.morbidreich.airform.repository.UserDetailsRepo;
import io.github.morbidreich.airform.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

	private UserRepo userRepo;
	private UserDetailsRepo userDetailsRepo;

	public UserService(UserRepo userRepo, UserDetailsRepo userDetailsRepo) {
		this.userRepo = userRepo;
		this.userDetailsRepo = userDetailsRepo;
	}

	public Optional<User> getUser(String name) {
		return userRepo.findByUsername(name);
	}

	@Transactional
	public void updateUserDetails(String username, UserDetails userDetails) {
		Optional<User> userOpt = userRepo.findByUsername(username);
		if (userOpt.isPresent()) {
			userDetailsRepo.save(userDetails);
			User u = userOpt.get();
			u.setUserDetails(userDetails);
			userRepo.save(u);
		}
	}
	@Transactional
	public boolean activateUser(String username) {
		Optional<User> userOptional = userRepo.findByUsername(username);
		if (userOptional.isPresent()) {
			userOptional.get().setActive(true);
			return true;
		}
		return false;
	}
}
