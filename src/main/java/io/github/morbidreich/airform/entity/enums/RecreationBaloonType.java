package io.github.morbidreich.airform.entity.enums;

public enum RecreationBaloonType {
    BALOON_LED("Balony LED"),
    BALOON_HELIUM("Balony z helem"),
    LANTERN("Lampiony");

    private final String displayValue;

    RecreationBaloonType(String description) {
        this.displayValue = description;
    }

    public String displayValue() {
        return displayValue;
    }
}
