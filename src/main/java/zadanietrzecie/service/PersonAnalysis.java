package zadanietrzecie.service;

import zadanietrzecie.model.Person;
import zadanietrzecie.model.Gender;

public class PersonAnalysis {

    private Person[] persons;

    public PersonAnalysis(Person[] persons) {
        this.persons = persons;
    }

    public int getAmountWomen() {
        int counter = 0;
        for (Person readPerson : persons) {
            if(readPerson != null){
                if(readPerson.getGender() == Gender.WOMEN){
                    counter++;
                }
            }
        }
        return counter;
    }

    public int getAmountMan() {
        int counter = 0;
        for (Person readPerson : persons) {
            if(readPerson != null){
                if(readPerson.getGender() == Gender.MAN){
                    counter++;
                }
            }
        }
        return counter;
    }

    public Person getPeopleWithLargestIncome() {
        Person richPerson = persons[0];
        for (Person readPerson : persons) {
            if (readPerson.getIncome() > richPerson.getIncome()){
                    richPerson = readPerson;
            }

        }
        return richPerson;
    }
}
