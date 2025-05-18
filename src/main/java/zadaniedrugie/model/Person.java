package zadaniedrugie.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    private int id;
    private String lastName;
    private String firstName;
    private String pesel;
    private LocalDate birthDay;

    public Person(int id, String lastName, String firstName, String pesel, LocalDate birthDay) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.pesel = pesel;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
    public abstract String getInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(pesel, person.pesel) && Objects.equals(birthDay, person.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, pesel, birthDay);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", birthDate=" + birthDay;
    }
}
