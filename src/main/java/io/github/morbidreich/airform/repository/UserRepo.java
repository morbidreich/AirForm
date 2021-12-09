package io.github.morbidreich.airform.repository;

import io.github.morbidreich.airform.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
	public Optional<User> findByUserName(String username);

}


