package io.github.morbidreich.airform.entity.forms;

import io.github.morbidreich.airform.dto.ProbingFormDto;
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

	public ProbingForm(ProbingFormDto form) {
		super();
		this.setApplicantUsername(form.getApplicantUsername());
		super.setFormStatus(form.getFormStatus());
		super.setName(form.getName());
		super.setPhone(form.getPhone());
		super.setEmail(form.getEmail());
		super.setRodo(form.isRodo());
		this.mainDateTime=form.getMainDateTime();
		this.backupDateTime=form.getBackupDateTime();
		this.location=form.getLocation();
		this.latitudeDegrees=form.getLatitudeDegrees();
		this.latitudeMinutes = form.getLatitudeMinutes();
		this.latitudeSeconds=form.getLatitudeSeconds();
		this.longitudeDegrees= form.getLongitudeDegrees();
		this.longitudeMinutes=form.getLongitudeMinutes();
		this.longitudeSeconds=form.getLongitudeSeconds();
		this.maxHeight=form.getMaxHeight();
		this.baloonColor=form.getBaloonColor();
		this.eventDescription=form.getDescription();
		this.probingBaloonSize =form.getProbingBaloonSize();
	}
}
