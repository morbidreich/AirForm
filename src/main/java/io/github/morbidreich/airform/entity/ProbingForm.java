package io.github.morbidreich.airform.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProbingForm {
	@Id
	private long id;
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
	private String description;
	private boolean rodo;

	//for testing my form will stop here
	/*
	private BaloonType baloonType;
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


	public ProbingForm() { }
}
