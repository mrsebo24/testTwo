package zadanietrzecie.model;

public enum PersonType {
    STUDENT("Student"),
    EMPLOYEE("Employee");

    private final String description;

    PersonType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
