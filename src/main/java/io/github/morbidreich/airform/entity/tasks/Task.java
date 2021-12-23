package io.github.morbidreich.airform.entity.tasks;

import io.github.morbidreich.airform.entity.forms.BaseForm;

import javax.persistence.*;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long employeeId;
	@OneToOne
	private BaseForm form;
}
