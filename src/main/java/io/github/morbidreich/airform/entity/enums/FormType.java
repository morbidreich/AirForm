package io.github.morbidreich.airform.entity.enums;

public enum FormType {
	PROBING("Sondowanie atmosfery"),
	FIREWORKS ("Sztuczne ognie"),
	LASERS_LIGHTS ("Pokazy lasery/światła"),
	HELIUM_BALOONS ("Balony z helem"),
	LANTERNS_LED_BALOONS ("Lampiony"),
	EXERCISE_COMPETITION ("Zawody/ćwiczenia");

	private final String description;

	FormType(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
