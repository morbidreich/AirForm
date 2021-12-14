package io.github.morbidreich.airform.entity.enums;

public enum RecreationBaloonType {
    BALOON_LED("Balony LED"),
    BALOON_HELIUM("Balony z helem"),
    LANTERN("Lampiony");

    private final String description;

    RecreationBaloonType(String description) {
        this.description = description;
    }

    @Override
    public String toString() { return description; }
}
