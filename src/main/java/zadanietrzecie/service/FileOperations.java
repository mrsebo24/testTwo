package zadanietrzecie.service;

import zadanietrzecie.model.Employee;
import zadanietrzecie.model.Person;
import zadanietrzecie.model.PersonType;
import zadanietrzecie.model.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    public FileOperations() {
    }

    public void save(String fileName, List<Person> personList) {
        try (
                PrintWriter save = new PrintWriter(fileName)
                ){
            for (Person readPerson : personList) {
                save.println(readPerson);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }


    public List<Person> readPersonList(String fileName) {
        List<Person> persons = new ArrayList<>();
        try (
                Scanner reader = new Scanner(new File(fileName))
                ){
            while (reader.hasNextLine()){
                persons.add(getPerson(reader.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return persons;
    }

    private Person getPerson(String line) {
        String[] personElements = line.trim().split(" ");
        if(personElements[0].equals(PersonType.EMPLOYEE.getDescription())) {
            return createEmployee(personElements);
        } else return createStudent(personElements);
    }


    private Student createStudent(String[] element) {
        return Student.checkPeselAndReturnStudent(element[1], element[2], element[3], element[4], element[5], Double.parseDouble(element[6]));
    }


    private Employee createEmployee(String[] element) {
        return Employee.checkPeselAndReturnEmployee(element[1], element[2], element[3], element[4], element[5], Double.parseDouble(element[6]));
    }


}
