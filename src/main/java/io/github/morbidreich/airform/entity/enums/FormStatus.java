package io.github.morbidreich.airform.entity.enums;

public enum FormStatus {
	FILED("Złożony"),
	PROCESSING("Procesowany"),
	FINISHED("Zakończony");

	private final String description;
	FormStatus(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}

	public String valueOf() {
		return description; }
}
