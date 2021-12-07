package io.github.morbidreich.airform.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class StratosphericBaloonForm {
	@Id
	private long id;
	private FormStatus formStatus;
	private String name;
	private String phone;
	private String email;
	private LocalDateTime mainDateTime;
	private LocalDateTime backupDateTime;
	private String location;
	private String latitude;
	private String longitude;
	private String baloonColor;
	private BaloonType baloonType;
	private Integer maxHeight;
	private Integer rateOfClimbDescent;
	private Integer noOfBaloons;
	private Integer circumreferenceOnGround;
	private Integer circumreferenceOnMaxHeight;
	private String colorAndCircumreferenceOfChute;
	private String payloadColor;
	private String beaconFrequency;
	private String payloadWeight;
	private String payloadSurfaceDensity;
	private String description;


	private StratosphericBaloonForm() { }

	public static class StratBaloonFormBuilder {


	}




}
