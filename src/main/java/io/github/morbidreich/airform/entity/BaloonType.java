package io.github.morbidreich.airform.entity;

public enum BaloonType {
	LIGHT("Lekki"),
	MEDIUM("Średni"),
	HEAVY("Ciężki");

	private final String displayValue;

	private BaloonType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String displayValue() {
		return displayValue;
	}
}
