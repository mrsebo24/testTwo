package zadaniedrugie.service;

import zadaniedrugie.model.Doctor;
import zadaniedrugie.model.Patient;
import zadaniedrugie.model.Visit;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileOperations {

    public FileOperations() {
    }

    public List<Patient> readPatientsAndReturn(File patientFileName) {
        List<Patient> patients = new ArrayList<>();
        try (
                Scanner reader = new Scanner(patientFileName)
        ){
            Set<String> patientPesel = new HashSet<>();

            if (reader.hasNextLine()){
                reader.nextLine();
            }
            while (reader.hasNextLine()){
                String[] patientAttributes = reader.nextLine().trim().split("\t");

                if (patientPesel.add(patientAttributes[getIndexPeselForPatient()])){
                    patients.add(createObjectPatient(patientAttributes));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + patientFileName);
        }return patients;
    }

    public List<Doctor> readDoctorsAndReturn(File doctorFileName){
        List<Doctor> doctors = new ArrayList<>();
        try (
                Scanner reader = new Scanner(doctorFileName)
                ){
            Set<String> uniquePesel = new HashSet<>();
            Set<String> uniqueNip = new HashSet<>();

            if (reader.hasNextLine()){
                reader.nextLine();
            }
            while (reader.hasNextLine()){
                String[] doctorAttributes = reader.nextLine().trim().split("\t");

                String pesel = doctorAttributes[getIndexPeselForDoctor()];
                String nip = doctorAttributes[getIndexNip()];
                if (uniquePesel.add(pesel) && uniqueNip.add(nip)){
                    doctors.add(createDoctor(doctorAttributes));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + doctorFileName);
        }return doctors;
    }

    private Doctor createDoctor(String[] doctorAttributes) {
        int id = Integer.parseInt(doctorAttributes[0]);
        String lastName = doctorAttributes[1];
        String firstName = doctorAttributes[2];
        String specialty = doctorAttributes[3];
        LocalDate birthDate = LocalDate.parse(doctorAttributes[4], getDateTimeFormatter());
        String nip = doctorAttributes[5];
        String pesel = doctorAttributes[6];
        return new Doctor(id, lastName, firstName, specialty, birthDate, nip, pesel);
    }

    public List<Visit> readVisitsAndReturn(File visitFileName, List<Doctor> doctors, List<Patient> patients){
        List<Visit> result = new ArrayList<>();
        try (
                Scanner reader = new Scanner(visitFileName)
                ){
            if (reader.hasNextLine()){
                reader.nextLine();
            }
            while (reader.hasNextLine()){
                String[] visitAttributes = reader.nextLine().trim().split("\t");

                Doctor currentDoctor = getDoctor(Integer.parseInt(visitAttributes[0]), doctors);
                Patient currentPatient = getPatient(Integer.parseInt(visitAttributes[1]), patients);

                if (currentPatient != null && currentDoctor != null){
                    result.add(new Visit(currentDoctor, currentPatient, LocalDate.parse(visitAttributes[2], getDateTimeFormatter())));
                }
            }
            assignVisitsToDoctors(result);
            assignVisitsToPatients(result);
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + visitFileName);
        }return result;
    }

    private Patient createObjectPatient(String[] patientAttributes) {
        int id = Integer.parseInt(patientAttributes[0]);
        String lastName = patientAttributes[1];
        String firstName = patientAttributes[2];
        String pesel = patientAttributes[3];
        LocalDate birthDate = LocalDate.parse(patientAttributes[4], getDateTimeFormatter());
        return new Patient(id, lastName, firstName, pesel, birthDate);
    }
    public void assignVisitsToDoctors(List<Visit> visits){
        for (Visit readVisit : visits) {
            Doctor doctor = readVisit.getDoctor();
            doctor.addVisit(readVisit);
        }
    }

    public void assignVisitsToPatients(List<Visit> visits){
        for (Visit readVisits : visits) {
            Patient patient = readVisits.getPatient();
            patient.addVisit(readVisits);
        }
    }
    private Doctor getDoctor(int doctorId, List<Doctor> doctors) {
        for (Doctor readDoctor : doctors) {
            if (readDoctor.getId() == doctorId) {
                return readDoctor;
            }
        }
        return null;
    }

    private Patient getPatient(int patientId, List<Patient> patients) {
        for (Patient readPatient : patients) {
            if (readPatient.getId() == patientId) {
                return readPatient;
            }
        }
        return null;
    }

    private int getIndexPeselForPatient() {
        return 3;
    }
    private int getIndexPeselForDoctor() {
        return 6;
    }

    private int getIndexNip() {
        return 5;
    }
    private DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-M-d");
    }

}
