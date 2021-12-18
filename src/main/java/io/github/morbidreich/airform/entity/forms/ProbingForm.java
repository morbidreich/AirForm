package io.github.morbidreich.airform.entity.forms;

import io.github.morbidreich.airform.entity.enums.FormType;
import io.github.morbidreich.airform.entity.enums.ProbingBaloonSize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="probing_form")
@Getter
@Setter
public class ProbingForm extends BaseForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@NotNull
	@Future(message = "Podaj przyszłą datę")
	private LocalDateTime mainDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@NotNull
	@Future(message = "Podaj przyszłą datę")
	private LocalDateTime backupDateTime;

	@NotEmpty
	private String location;

	@NotNull
	@Min(value = 49, message = "To nie w Polsce!")
	@Max(value = 55, message = "To nie w Polsce!")
	private int latitudeDegrees;

	@NotNull
	@Min(0)
	@Max(59)
	private int latitudeMinutes;

	@NotNull
	@Min(0)
	@Max(59)
	private int latitudeSeconds;

	@NotNull
	@Min(value = 13, message = "To nie w Polsce!")
	@Max(value = 25, message = "To nie w Polsce!")// range of polish longitudes
	private int longitudeDegrees;

	@NotNull
	@Min(0)
	@Max(59)
	private int longitudeMinutes;

	@NotNull
	@Min(0)
	@Max(59)
	private int longitudeSeconds;

	@NotNull
	@Min(1)
	private Integer maxHeight;

	@NotEmpty
	private String baloonColor;

	@NotEmpty
	@Size(max = 254)
	private String description;

	@Enumerated(EnumType.STRING)
	private ProbingBaloonSize probingBaloonSize;

	//for testing my form will stop here
	/*
	private Integer rateOfClimbDescent;
	private Integer noOfBaloons;
	private Integer circumreferenceOnGround;
	private Integer circumreferenceOnMaxHeight;
	private String colorAndCircumreferenceOfChute;
	private String payloadColor;
	private String beaconFrequency;
	private String payloadWeight;
	private String payloadSurfaceDensity;
	*/

	public ProbingForm() {
		super();
		this.setFormType(FormType.PROBING);
	}

}
