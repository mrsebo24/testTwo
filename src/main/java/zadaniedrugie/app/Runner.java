package zadaniedrugie.app;

import zadaniedrugie.model.Doctor;
import zadaniedrugie.model.Patient;
import zadaniedrugie.model.Visit;
import zadaniedrugie.service.AnalysisVisits;
import zadaniedrugie.service.FileOperations;

import java.io.File;
import java.util.List;
//uwaga!!!!! w niektorych klasach dodalem metode getInfo jest ona wylacznie dla czytelnosci!!
public class Runner {
    public static void main(String[] args) {


        FileOperations fileOperations = new FileOperations();
        List<Doctor> doctors = fileOperations.readDoctorsAndReturn(new File("lekarze.txt"));
        List<Patient> patients = fileOperations.readPatientsAndReturn(new File("pacjenci.txt"));

        List<Visit> visitList = fileOperations.readVisitsAndReturn(new File("wizyty.txt"),doctors, patients);
        fileOperations.assignVisitsToDoctors(visitList);

        AnalysisVisits analysisVisits = new AnalysisVisits(doctors, patients, visitList);

        //- znajdŸ lekarza ktory mia³ najwiêcej wizyt
        System.out.println("analysisVisits.getDoctorWithMostVisit() = " + analysisVisits.getDoctorWithMostVisit());
        System.out.println("-----------");
        //- znajdŸ pacjenta który mia³ najwiêcej wizyt
        System.out.println("analysisVisits.getPatientWithMostVisit() = " + analysisVisits.getPatientWithMostVisit());
        System.out.println("-----------");
        //- która specalizacja cieszy siê najwiêkszym powodzeniem?
        System.out.println("analysisVisits.getPopularSpecialty() = " + analysisVisits.getPopularSpecialty());
        System.out.println("-----------");

        //- którego roku by³o najwiêcej wizyt?
        System.out.println("analysisVisits.getMostPopularVisitYear() = " + analysisVisits.getMostPopularVisitYear());
        System.out.println("------------");
        //- wypisz top 5 najstarszych lekarzy
        System.out.println("analysisVisits.getTopFiveOlderDoctors() = " + analysisVisits.getTopFiveOlderDoctors());
        System.out.println("------------");
        //- wypisz top 5 lekarzy co mieli najwiecej wizyt
        System.out.println("analysisVisits.getTopFiveDoctorsWithMostVisit() = " + analysisVisits.getTopFiveDoctorsWithMostVisit());
        System.out.println("-------------");
        //- zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy
        System.out.println("analysisVisits.getPatientsWithFiveDifferentDoctors() = " + analysisVisits.getPatientsWithFiveDifferentDoctors());
        System.out.println("--------------");
        //- zwroc lekarzy ktorzy przyjeli tylko jednego pacjenta
        System.out.println("analysisVisits.getDoctorsWithOnlyOnePatient() = " + analysisVisits.getDoctorsWithOnlyOnePatient());
        System.out.println("-------------");

        for (Doctor topFiveOlderDoctor : analysisVisits.getTopFiveOlderDoctors()) {
            System.out.println(topFiveOlderDoctor.getBirthDay());
        }


        System.out.println("------");
    }
}
