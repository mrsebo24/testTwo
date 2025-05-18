package zadaniedrugie.model;

import java.time.LocalDate;

public class Visit {
    private Doctor doctor;
    private Patient patient;
    private LocalDate visitDate;

    public Visit(Doctor doctor, Patient patient, LocalDate visitDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.visitDate = visitDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }


    public String getInfo() {
        return doctor.getId() + " "
                + patient.getId() + " "
                + visitDate;
    }

}
