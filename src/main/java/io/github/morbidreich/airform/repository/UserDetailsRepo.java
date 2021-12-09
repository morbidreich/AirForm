package io.github.morbidreich.airform.repository;

import io.github.morbidreich.airform.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepo extends CrudRepository<UserDetails, Long> {
}
