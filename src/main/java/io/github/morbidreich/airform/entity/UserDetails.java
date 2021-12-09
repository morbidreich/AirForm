package io.github.morbidreich.airform.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String surname;
	private String adress;
	private String phone;

	public UserDetails() {
	}

	public UserDetails(String name, String surname, String adress, String phone) {
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.phone = phone;
	}
}
