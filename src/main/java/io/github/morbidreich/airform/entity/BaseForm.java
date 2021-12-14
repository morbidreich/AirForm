package io.github.morbidreich.airform.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDateTime applicationDateTime;
	private String applicantUsername;
	private String name;
	private String phone;
	private String email;
	@Enumerated(EnumType.STRING)
	private FormType formType;
	@Enumerated(EnumType.STRING)
	private FormStatus formStatus;
	private String asmResponse;
	private boolean rodo;

	public BaseForm() {
		applicationDateTime = LocalDateTime.now();
	}
}
