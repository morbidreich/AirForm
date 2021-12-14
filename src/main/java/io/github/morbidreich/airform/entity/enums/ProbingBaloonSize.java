package io.github.morbidreich.airform.entity.enums;

public enum ProbingBaloonSize {
	LIGHT("Lekki"),
	MEDIUM("Średni"),
	HEAVY("Ciężki");

	private final String displayValue;

	private ProbingBaloonSize(String displayValue) {
		this.displayValue = displayValue;
	}

	public String displayValue() {
		return displayValue;
	}
}
