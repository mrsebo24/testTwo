package zadaniepierwsze.model;

public enum Gender {

    GIRL('c'),
    BOY('s');

    private final char description;

    Gender(char description) {
        this.description = description;
    }

    public char getDescription() {
        return description;
    }
}
