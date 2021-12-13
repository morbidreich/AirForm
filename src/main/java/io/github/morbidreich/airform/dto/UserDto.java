package io.github.morbidreich.airform.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	private String username;
	private String password;
	private String email;
	private boolean active;
	private String roles;
	private LocalDateTime created;
}
