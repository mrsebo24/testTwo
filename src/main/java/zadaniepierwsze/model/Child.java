package zadaniepierwsze.model;

import java.time.LocalDate;
import java.util.Objects;

//identyfikator, płeć (c – córka, s – syn), imię, data urodzenia, waga [g], wzrost [cm] oraz identyfikator matki.
public class Child extends Person {

    private Gender gender;
    private LocalDate birthDay;
    private double weightInGrams;
    private int heightInCm;
    private Mother mother;

    public Child(int id, Gender gender, String imie, LocalDate birthDate, double weightInGrams, int heightInCm) {
        super(id, imie);
        this.gender = gender;
        this.birthDay = birthDate;
        this.weightInGrams = weightInGrams;
        this.heightInCm = heightInCm;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public LocalDate getBirthDate() {
        return birthDay;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDay = birthDate;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(double weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Double.compare(child.weightInGrams, weightInGrams) == 0 && heightInCm == child.heightInCm && gender == child.gender && Objects.equals(birthDay, child.birthDay) && Objects.equals(mother, child.mother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, birthDay, weightInGrams, heightInCm, mother);
    }

    @Override
    public String getInfo() {
        return getId() + " " + gender.getDescription() + " "
                + getFirstName() + " " + getBirthDate() + " "
                + weightInGrams + " " + heightInCm + " "
                + mother.getId();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", gender=" + gender.getDescription() +
                ", birthDate=" + birthDay +
                ", weightInGrams=" + weightInGrams +
                ", heightInCm=" + heightInCm +
                ", mother=" + mother +
                '}';
    }
}
