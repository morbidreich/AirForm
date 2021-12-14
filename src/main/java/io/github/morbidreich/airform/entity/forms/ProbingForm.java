package io.github.morbidreich.airform.entity.forms;

import io.github.morbidreich.airform.entity.enums.ProbingBaloonSize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="probing_form")
@Getter
@Setter
public class ProbingForm extends BaseForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime mainDateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime backupDateTime;
	private String location;
	private int latitudeDegrees;
	private int latitudeMinutes;
	private int latitudeSeconds;
	private int longitudeDegrees;
	private int longitudeMinutes;
	private int longitudeSeconds;
	private Integer maxHeight;
	private String baloonColor;
	private String eventDescription;
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
	}

}
