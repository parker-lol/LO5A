public enum Setting {
    OFF("[---]"),
    LOW("[--+]"),
    MEDIUM("[-++]"),
    HIGH("[+++]");

    private final String displayValue;

    private Setting(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return this.displayValue;
    }
}