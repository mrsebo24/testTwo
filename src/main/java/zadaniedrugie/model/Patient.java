package zadaniedrugie.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// jego nazwisko, imiê, numer PESEL i datê urodzenia
public class Patient extends Person {
    private List<Visit> visitList;

    public Patient(int id, String lastName, String firstName, String pesel, LocalDate birthDate) {
        super(id, lastName, firstName, pesel, birthDate);
        this.visitList = new ArrayList<>();
    }

    public void addVisit(Visit visit){
        visitList.add(visit);
    }
    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(visitList, patient.visitList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), visitList);
    }

    public String getInfo() {
        return getId() + " " + getLastName() +
                " " + getFirstName() + " " + getPesel() +
                " " + getBirthDay();
    }

    @Override
    public String toString() {
        return super.toString() + "}";
    }
}
