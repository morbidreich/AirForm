package io.github.morbidreich.airform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	private String username;
	private String password;
	private String email;
	private boolean active;
	private String roles;
	private LocalDateTime created;
	@OneToOne
	private UserDetails userDetails;

	public User(String username, String password, String email, boolean active, String roles) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.roles = roles;
		created = LocalDateTime.now();
	}
	public Optional<UserDetails> getUserDetailsOpt() {
		return Optional.ofNullable(userDetails);
	}
}
