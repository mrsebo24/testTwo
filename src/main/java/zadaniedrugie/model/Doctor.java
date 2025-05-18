package zadaniedrugie.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//numer identyfikacyjny
//lekarza, jego nazwisko, imiê, specjalnoœæ, datê urodzenia, numer NIP i numer PESEL.
public class Doctor extends Person {
    private String specialty;
    private String nip;
    private List<Visit> visitList;
    public Doctor(int id, String lastName, String firstName, String specialty, LocalDate birthDate, String nip, String pesel) {
        super(id, lastName, firstName, pesel, birthDate);
        this.specialty = specialty;
        this.nip = nip;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getInfo() {
        return getId() + " " + getLastName() +
                " " + getFirstName() + " " + specialty +
                " " + getBirthDay() + " " + nip +
                " " + getPesel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(specialty, doctor.specialty) && Objects.equals(nip, doctor.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialty, nip);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", specialty='" + specialty + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }
}
