package io.github.morbidreich.airform.entity.tasks;

import io.github.morbidreich.airform.entity.forms.BaseForm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long employeeId;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime finishTime;
	@OneToOne
	private BaseForm form;

	public Task() {
		startTime = LocalDateTime.now();
	}
}
