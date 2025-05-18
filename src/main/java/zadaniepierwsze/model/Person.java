package zadaniepierwsze.model;

public abstract class Person {
    private int id;
    private String firstName;

    public Person(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public abstract String getInfo();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", firstName='" + firstName;
    }
}
