package io.github.morbidreich.airform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String password;
	private String email;
	private boolean active;
	private String roles;
	private LocalDateTime created;
	@OneToOne
	private UserDetails userDetails;

	public User(String userName, String password, String email, boolean active, String roles) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.active = active;
		this.roles = roles;
		created = LocalDateTime.now();
	}
}
