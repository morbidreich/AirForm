package io.github.morbidreich.airform.entity;

public enum FormStatus {
	FILED("Złożony"),
	PROCESSED("Procesowany"),
	FINISHED("Zakończony");

	private final String description;
	FormStatus(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
