package zadaniepierwsze.service;

import zadaniepierwsze.model.*;

import java.time.DayOfWeek;
import java.util.*;

public class HospitalDataAnalysis {

    private List<Child> children;
    private List<Mother> mothers;
    public HospitalDataAnalysis(List<Child> children, List<Mother> mothers) {
        this.children = children;
        this.mothers = mothers;
    }


    ////  a) Podaj imiê i wzrost najwy¿szego ch³opca oraz imiê i wzrost najwy¿szej dziewczynki.
    public List<Child> getHighestBoyAndGirl() {
        List<Child> boys = getBoys();
        List<Child> girls = getGirls();

        boys.sort(Comparator.comparingInt(Child::getHeightInCm));
        girls.sort(Comparator.comparingInt(Child::getHeightInCm));

        int highestBoy = boys.size() - 1;
        int highestGirl = girls.size() - 1;

        List<Child> result = new ArrayList<>();
        result.add(boys.get(highestBoy));
        result.add(girls.get(highestGirl));
        return result;

    }

    //    //b) W którym dniu tygodnia urodzi³o siê najwiêcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
    public MostPopularBirthdayAndNumberOfChildren getMostPopularBirthdayAndNumberOfChildren() {
        int[] dayCounts = getDayArray();

        int maxCount = 0;
        int maxIndex = 0;

        for (int i = 0; i < dayCounts.length; i++) {
            if (dayCounts[i] > maxCount) {
                maxCount = dayCounts[i];
                maxIndex = i;
            }
        }

        DayOfWeek mostPopularDay = DayOfWeek.of(maxIndex + 1);
        return new MostPopularBirthdayAndNumberOfChildren(mostPopularDay, maxCount);
    }

    //    //c) Podaj imiona kobiet w wieku poni¿ej 25 lat, które urodzi³y dzieci o wadze powy¿ej 4000 g.
    public List<Mother> getMothersBelow25YearAndAboveWeightChild4000() {
        List<Mother> mothersResult = new ArrayList<>();
        int motherAge = 25;
        double childWeight = 4000;
        for (Mother readMother : mothers) {
            if (readMother.getAge() < motherAge && isHeavy(readMother, childWeight)){
                mothersResult.add(readMother);
            }
        }
        return mothersResult;
    }

    ////    //d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczy³y imiê po matce.
    public List<Child> getGirlsWithNameAsMother() {
        List<Child> result = new ArrayList<>();
        for (Child readGirl : getGirls()) {
            String currentGirlName = readGirl.getFirstName();
            String currentMotherName = readGirl.getMother().getFirstName();
            if (currentGirlName.equals(currentMotherName)) {
                result.add(readGirl);
            }
        }
        return result;
    }

    ////    //e) Znajdz matki które urodzi³y bliŸniêta.
    public List<Mother> getMotherOfTwins() {
        List<Mother> motherOfTwins = new ArrayList<>();
        int twins = 2;
        for (Mother readMother : mothers) {
            if (readMother.getChildren().size() == twins){
                motherOfTwins.add(readMother);
            }
        }return motherOfTwins;
    }

    private int[] getDayArray() {
        int week = 7;
        int[] dayCounts = new int[week];

        for (Child child : children) {
            DayOfWeek day = child.getBirthDate().getDayOfWeek();
            int index = day.getValue() - 1;
            dayCounts[index]++;
        }
        return dayCounts;
    }

    private boolean isHeavy(Mother mother, double childWeight){
        boolean result = false;
        for (Child readChild : mother.getChildren()) {
            if (readChild.getWeightInGrams() > childWeight) {
                result = true;
                break;
            }
        }return result;
    }

    private List<Child> getGirls(){
        List<Child> girls = new ArrayList<>();
        for (Child readGirl : children) {
            if (readGirl.getGender() == Gender.GIRL) {
                girls.add(readGirl);
            }
        }
        return girls;
    }
    private List<Child> getBoys() {
        List<Child> boys = new ArrayList<>();
        for (Child readBoy : children) {
            if (readBoy.getGender() == Gender.BOY){
                boys.add(readBoy);
            }
        }
        return boys;
    }
}
