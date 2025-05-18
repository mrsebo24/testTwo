package zadaniepierwsze.app;

import zadaniepierwsze.model.Child;
import zadaniepierwsze.model.Mother;
import zadaniepierwsze.service.HospitalDataAnalysis;
import zadaniepierwsze.service.FileOperations;

import java.io.File;
import java.util.*;

public class Runner {
    public static void main(String[] args) {


        FileOperations fileOperations = new FileOperations();
        List<Mother> mothers = fileOperations.readMothers(new File("mamy.txt"));
        List<Child> children = fileOperations.readChildren(new File("noworodki.txt"), mothers);

        HospitalDataAnalysis hospitalDataAnalysis = new HospitalDataAnalysis(children, mothers);

//        a) Podaj imiê i wzrost najwy¿szego ch³opca oraz imiê i wzrost najwy¿szej dziewczynki.
        for (Child child : hospitalDataAnalysis.getHighestBoyAndGirl()) {
            System.out.println("imie: " + child.getFirstName() + " height: " + child.getHeightInCm());
        }
        System.out.println("-----------");


//        b) W którym dniu tygodnia urodzi³o siê najwiêcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
        System.out.println("analysisDataHospital.getMostPopularBirthdayAndNumberOfChildren() = " + hospitalDataAnalysis.getMostPopularBirthdayAndNumberOfChildren());
        System.out.println("-----------");


//        c) Podaj imiona kobiet w wieku poni¿ej 25 lat, które urodzi³y dzieci o wadze powy¿ej 4000 g.
        for (Mother mother : hospitalDataAnalysis.getMothersBelow25YearAndAboveWeightChild4000()) {
            System.out.println("mother name: " + mother.getFirstName());
        }System.out.println("-----------");


//         d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczy³y imiê po matce.
        for (Child child : hospitalDataAnalysis.getGirlsWithNameAsMother()) {
            System.out.println("name: " + child.getFirstName() + " " + child.getBirthDate());
        }System.out.println("-----------");


//        e) Znajdz matki które urodzi³y bliŸniêta.
        for (Mother motherOfTwin : hospitalDataAnalysis.getMotherOfTwins()) {
            System.out.println(motherOfTwin);
        }


    }
}
