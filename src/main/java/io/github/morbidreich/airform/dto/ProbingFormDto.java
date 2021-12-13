package io.github.morbidreich.airform.dto;

import io.github.morbidreich.airform.entity.BaloonType;
import io.github.morbidreich.airform.entity.FormStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ProbingFormDto {

	// builder for training
	public static class Builder {

		private long id;
		private String applicantUsername;
		private LocalDateTime applicationDateTime;
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
		private BaloonType baloonType;
		private boolean rodo;

		public Builder() {
		}

		public Builder withFormStatus(FormStatus formStatus) {
			this.formStatus = formStatus;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withMainDateTime(LocalDateTime mainDateTime) {
			this.mainDateTime = mainDateTime;
			return this;
		}

		public Builder withBackupDateTime(LocalDateTime backupDateTime) {
			this.backupDateTime = backupDateTime;
			return this;
		}

		public Builder withBaloonType(BaloonType baloonType) {
			this.baloonType = baloonType;
			return this;
		}

		public Builder withLocation(String location) {
			this.location = location;
			return this;
		}

		public Builder withLatitudeDegrees(int latitudeDegrees) {
			this.latitudeDegrees = latitudeDegrees;
			return this;
		}

		public Builder withLatitudeMunutes(int latitudeMinutes) {
			this.latitudeMinutes = latitudeMinutes;
			return this;
		}

		public Builder withLatitudeSeconds(int latitudeSeconds) {
			this.latitudeSeconds = latitudeSeconds;
			return this;
		}

		public Builder withLongitudeDegrees(int longitudeDegrees) {
			this.longitudeDegrees = longitudeDegrees;
			return this;
		}

		public Builder withLongitudeMinutes(int longitudeMinutes) {
			this.longitudeMinutes = longitudeMinutes;
			return this;
		}

		public Builder withLongitudeSeconds(int longitudeSeconds) {
			this.longitudeSeconds = longitudeSeconds;
			return this;
		}

		public Builder withMaxHeight(int maxHeight) {
			this.maxHeight = maxHeight;
			return this;
		}

		public Builder withBaloonColor(String color) {
			this.baloonColor = color;
			return this;
		}

		public Builder withDescription(String description) {
			this.eventDescription = description;
			return this;
		}

		public Builder withRodo(boolean rodo) {
			this.rodo = rodo;
			return this;
		}

		public ProbingFormDto build() {
			ProbingFormDto out = new ProbingFormDto();
			out.applicationDateTime = LocalDateTime.now();
			out.formStatus = this.formStatus;
			out.name = this.name;
			out.phone = this.phone;
			out.email = this.email;
			out.mainDateTime = this.mainDateTime;
			out.backupDateTime = this.backupDateTime;
			out.location = this.location;

			return out;
		}
	}

	// should be private constructor because builder
	// but builder is just for practice
	public ProbingFormDto() {
	}

	private long id;
	private LocalDateTime applicationDateTime;
	private String applicantUsername;
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
	private BaloonType baloonType;
	private boolean rodo;
}
