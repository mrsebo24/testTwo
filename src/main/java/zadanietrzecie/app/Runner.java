package zadanietrzecie.app;

import zadanietrzecie.model.Person;
import zadanietrzecie.model.Employee;
import zadanietrzecie.model.Student;
import zadanietrzecie.service.PersonAnalysis;
import zadanietrzecie.service.FileOperations;


import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Person[] people = {
            Student.checkPeselAndReturnStudent("Monika", "W", "83495834288", "Raszyn", "jezykowa", 180.0),
            Student.checkPeselAndReturnStudent("Walery", "Kalasznikov", "12345678911", "Pruszków", "jezykowa", 140.0),
            Student.checkPeselAndReturnStudent("Julia", "Ciasnicka", "82934578236", "Otwock", "jezykowa", 1400.0),
            Employee.checkPeselAndReturnEmployee("Micha³", "tr¹ba", "12345678911", "wieliszew", "nauczyciel", 8000.0),
            Employee.checkPeselAndReturnEmployee("Kamila", "Broda", "34906790342", "Legionowo", "sprz¹taczka", 4500.0),
            Employee.checkPeselAndReturnEmployee("Tomasz", "Murarz", "28935489251", "wieliszew", "chemik", 3500.0)
        };

        List<Person> personList = List.of(
                Student.checkPeselAndReturnStudent("Monika", "Warda", "83495834288", "Raszyn", "jezykowa", 180.0),
                Student.checkPeselAndReturnStudent("Walery", "Kalasznikov", "12345678911", "Pruszków", "jezykowa", 140.0),
                Student.checkPeselAndReturnStudent("Julia", "Ciasnicka", "82934578236", "Otwock", "jezykowa", 1400.0),
                Employee.checkPeselAndReturnEmployee("Micha³", "tr¹ba", "12345678911", "wieliszew", "nauczyciel", 8000.0),
                Employee.checkPeselAndReturnEmployee("Kamila", "Broda", "34906790342", "Legionowo", "sprz¹taczka", 4500.0),
                Employee.checkPeselAndReturnEmployee("Tomasz", "Murarz", "28935489251", "wieliszew", "chemik", 3500.0)
        );

        FileOperations fileOperations = new FileOperations();
        fileOperations.save("person.txt", personList);
        List<Person> people1 = fileOperations.readPersonList("person.txt");
        for (Person person : people1) {
            System.out.println(person);
        }

        System.out.println("-----------");
        PersonAnalysis personAnalysis = new PersonAnalysis(people);
        System.out.println("personalDataAnalysises.getSizeMan() = " + personAnalysis.getAmountMan());
        System.out.println("personalDataAnalysises.getSizeWomen() = " + personAnalysis.getAmountWomen());
        Person personWithLargestIncome = personAnalysis.getPeopleWithLargestIncome();
        System.out.println("osobaZnajwiekszymDochodem = " + personWithLargestIncome);

    }
}

