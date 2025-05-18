package zadaniedrugie.service;

import zadaniedrugie.model.Doctor;
import zadaniedrugie.model.Patient;
import zadaniedrugie.model.Visit;

import java.util.*;

public class AnalysisVisits {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Visit> visits;

    public AnalysisVisits(List<Doctor> doctors, List<Patient> patients, List<Visit> visits) {
        this.doctors = doctors;
        this.patients = patients;
        this.visits = visits;
    }

    //- znajdŸ lekarza ktory mia³ najwiêcej wizyt
    public Doctor getDoctorWithMostVisit(){
        Doctor mostPopularDoctor = null;
        int maxVisitNumber = 0;
        for (Doctor readDoctor : doctors) {
            int numberVisitsCurrentDoctor = readDoctor.getVisitList().size();
            if (numberVisitsCurrentDoctor > maxVisitNumber){
                maxVisitNumber = numberVisitsCurrentDoctor;
                mostPopularDoctor = readDoctor;
            }
        }return mostPopularDoctor;
    }

    //- znajdŸ pacjenta który mia³ najwiêcej wizyt
    public Patient getPatientWithMostVisit(){
        Patient mostPopularPatient = null;
        int maxVisit = 0;
        for (Patient readPatient : patients) {
            int numberVisitsCurrentPatient = readPatient.getVisitList().size();
            if (numberVisitsCurrentPatient > maxVisit){
                maxVisit = numberVisitsCurrentPatient;
                mostPopularPatient = readPatient;
            }
        }return mostPopularPatient;
    }

    //- która specalizacja cieszy siê najwiêkszym powodzeniem?
    public String getPopularSpecialty(){
        List<String> specialties = getListSpecialityWithDuplicate();

        String mostPopular = specialties.get(0);
        String current = specialties.get(0);
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < specialties.size(); i++) {
            if (specialties.get(i).equals(current)) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostPopular = current;
                }
                current = specialties.get(i);
                currentCount = 1;
            }
        }
        if (currentCount > maxCount) {
            mostPopular = current;
        }return mostPopular;
    }

    public List<String> getListStringSpecialtyFromDoctors(List<Doctor> doctors) {
        List<String> allSpecialty = new ArrayList<>();
        for (Doctor doctor : doctors) {
            allSpecialty.add(doctor.getSpecialty());
        }
        return allSpecialty;
    }
//    - którego roku by³o najwiêcej wizyt?
    public int getMostPopularVisitYear(){
        List<Integer> allYears = getListAllYearsWithDuplicate();

        int mostPopularYear = allYears.get(0);
        int currentYear = allYears.get(0);
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < allYears.size(); i++) {
            if (allYears.get(i) == currentYear) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostPopularYear = currentYear;
                }
                currentYear = allYears.get(i);
                currentCount = 1;
            }
        }
        if (currentCount > maxCount) {
            mostPopularYear = currentYear;
        }return mostPopularYear;
    }

    //- wypisz top 5 najstarszych lekarzy
    public List<Doctor> getTopFiveOlderDoctors(){
        List<Doctor> copyDoctors = doctors;
        Set<Doctor> uniqueSortDoctors = new TreeSet<>(Comparator.comparing(
                Doctor::getBirthDay).thenComparing(Doctor::getFirstName));
        uniqueSortDoctors.addAll(copyDoctors);
        return getListTopFiveDoctors(uniqueSortDoctors);
    }
    //- wypisz top 5 lekarzy co mieli najwiecej wizyt
    public List<Doctor> getTopFiveDoctorsWithMostVisit() {
        List<Doctor> copyDoctors = doctors;
        Set<Doctor> uniqueSortDoctors = new TreeSet<>(Comparator.comparing(
                        (Doctor doctor) -> doctor.getVisitList().size())
                .reversed()
                .thenComparing(Doctor::getFirstName));
        uniqueSortDoctors.addAll(copyDoctors);
        return getListTopFiveDoctors(uniqueSortDoctors);
    }

    //- zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy
    public List<Patient> getPatientsWithFiveDifferentDoctors(){
        List<Patient> patientWithFiveDifferentDoctors = new ArrayList<>();

        Patient currentPatient;
        Set<Doctor> uniqueDoctors = new HashSet<>();
        for (Visit readVisit : visits) {
            currentPatient = readVisit.getPatient();

            if(!readVisit.getPatient().equals(currentPatient)){
                if(uniqueDoctors.size() >= 5){
                    patientWithFiveDifferentDoctors.add(currentPatient);
                }
                uniqueDoctors.clear();
            }
            uniqueDoctors.add(readVisit.getDoctor());
        }return patientWithFiveDifferentDoctors;
    }


    //- zwroc lekarzy ktorzy przyjeli tylko jednego pacjenta
    public List<Doctor> getDoctorsWithOnlyOnePatient(){
        List<Doctor> doctorsWithOnlyOnePatient = new ArrayList<>();

        Doctor currentDoctor;
        List<Patient> patientList = new ArrayList<>();
        for (Visit visit : visits) {
            currentDoctor = visit.getDoctor();

            if (!currentDoctor.equals(visit.getDoctor())){
                if (patientList.size() == 1){
                    doctorsWithOnlyOnePatient.add(currentDoctor);
                }
                patientList.clear();
            }
            patientList.add(visit.getPatient());
        }return doctorsWithOnlyOnePatient;
    }

    private List<Doctor> getListTopFiveDoctors(Set<Doctor> doctorSet) {
        List<Doctor> topFiveDoctors = new ArrayList<>();
        int count = 0;
        for (Doctor doctor : doctorSet) {
            if (count >= 5) break;
            topFiveDoctors.add(doctor);
            count++;
        }return topFiveDoctors;
    }
    private List<Integer> getListAllYearsWithDuplicate() {
        List<Integer> allYears = new ArrayList<>();
        for (Visit readVisit : visits) {
            allYears.add(readVisit.getVisitDate().getYear());
        }
        Collections.sort(allYears);
        return allYears;
    }
    private List<String> getListSpecialityWithDuplicate() {
        List<String> specialties = new ArrayList<>();
        for (Doctor doctor : doctors) {
            specialties.add(doctor.getSpecialty());
        }
        Collections.sort(specialties);
        return specialties;
    }
}
