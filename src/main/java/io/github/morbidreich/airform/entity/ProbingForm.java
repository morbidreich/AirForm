package io.github.morbidreich.airform.entity;

import io.github.morbidreich.airform.dto.ProbingFormDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="probing_form")
@Getter
@Setter
public class ProbingForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime applicationDateTime;
	private String applicantUsername;
	@Enumerated(EnumType.STRING)
	private FormStatus formStatus;
	private String name;
	private String phone;
	private String email;
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
	private BaloonType baloonType;
	private boolean rodo;

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
		this.applicationDateTime = LocalDateTime.now();
	}

	public ProbingForm(ProbingFormDto form) {

		this.applicationDateTime = LocalDateTime.now();
		this.applicantUsername=form.getApplicantUsername();
		this.formStatus=form.getFormStatus();
		this.name=form.getName();
		this.phone=form.getPhone();
		this.email=form.getEmail();
		this.mainDateTime=form.getMainDateTime();
		this.backupDateTime=form.getBackupDateTime();
		this.location=form.getLocation();
		this.latitudeDegrees=form.getLatitudeDegrees();
		this.latitudeMinutes = form.getLatitudeMinutes();
		this.latitudeSeconds=form.getLatitudeSeconds();
		this.longitudeDegrees= form.getLongitudeSeconds();
		this.longitudeMinutes=form.getLongitudeMinutes();
		this.longitudeSeconds=form.getLongitudeSeconds();
		this.maxHeight=form.getMaxHeight();
		this.baloonColor=form.getBaloonColor();
		this.eventDescription=form.getDescription();
		this.baloonType=form.getBaloonType();
		this.rodo=form.isRodo();
	}
}
