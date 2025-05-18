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

//        a) Podaj imi� i wzrost najwy�szego ch�opca oraz imi� i wzrost najwy�szej dziewczynki.
        for (Child child : hospitalDataAnalysis.getHighestBoyAndGirl()) {
            System.out.println("imie: " + child.getFirstName() + " height: " + child.getHeightInCm());
        }
        System.out.println("-----------");


//        b) W kt�rym dniu tygodnia urodzi�o si� najwi�cej dzieci? Podaj dzien tygodnia i liczbe dzieci.
        System.out.println("analysisDataHospital.getMostPopularBirthdayAndNumberOfChildren() = " + hospitalDataAnalysis.getMostPopularBirthdayAndNumberOfChildren());
        System.out.println("-----------");


//        c) Podaj imiona kobiet w wieku poni�ej 25 lat, kt�re urodzi�y dzieci o wadze powy�ej 4000 g.
        for (Mother mother : hospitalDataAnalysis.getMothersBelow25YearAndAboveWeightChild4000()) {
            System.out.println("mother name: " + mother.getFirstName());
        }System.out.println("-----------");


//         d) Podaj imiona i daty urodzenia dziewczynek, kt�re odziedziczy�y imi� po matce.
        for (Child child : hospitalDataAnalysis.getGirlsWithNameAsMother()) {
            System.out.println("name: " + child.getFirstName() + " " + child.getBirthDate());
        }System.out.println("-----------");


//        e) Znajdz matki kt�re urodzi�y bli�ni�ta.
        for (Mother motherOfTwin : hospitalDataAnalysis.getMotherOfTwins()) {
            System.out.println(motherOfTwin);
        }


    }
}
