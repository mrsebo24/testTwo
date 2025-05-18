package zadaniepierwsze.service;

import zadaniepierwsze.model.Child;
import zadaniepierwsze.model.Mother;
import zadaniepierwsze.model.Gender;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    public FileOperations() {
    }


    public List<Child> readChildren(File childrenFile, List<Mother> mothers) {
        List<Child> result = new ArrayList<>();
        try (
                Scanner reader = new Scanner(childrenFile)
        ){
            while (reader.hasNextLine()){
                Child currentChild = getChildren(reader.nextLine(), mothers);
                if (currentChild != null) {
                    result.add(getChildren(reader.nextLine(), mothers));
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + childrenFile);
        }return result;
    }


    public List<Mother> readMothers(File mothersFile) {
        List<Mother> mothers = new ArrayList<>();
        try (
                Scanner reader = new Scanner(mothersFile)
        ){
            while (reader.hasNextLine()){
                mothers.add(createMother(reader.nextLine()));

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + mothersFile);
        }return mothers;
    }


    private Mother createMother(String line) {
        String[] motherAttributes = line.trim().split(" ");
        return new Mother(Integer.parseInt(motherAttributes[0]), motherAttributes[1], Integer.parseInt(motherAttributes[2]));
    }


    private Child getChildren(String line, List<Mother> mothers) {
        String[] childrenAttributes = line.trim().split(" ");
        Child child = null;
        Gender gender = assignGender(childrenAttributes[1]);
        if (gender != null) {
            child = createChild(childrenAttributes, gender);
            Mother motherOfCurrentChild = findMotherById(mothers, Integer.parseInt(childrenAttributes[6]));
            createRelation(child, motherOfCurrentChild);
        }
        return child;
    }

    private Child createRelation(Child child, Mother mother) {
        if (child != null && mother != null){
            child.setMother(mother);
            mother.addChildren(child);
            return child;
        }
        return null;
    }

    private Child createChild(String[] childAttributes, Gender gender) {
        int id = Integer.parseInt(childAttributes[0]);
        String name = childAttributes[2];
        LocalDate birthDay = LocalDate.parse(childAttributes[3]);
        double weightInGrams = Double.parseDouble(childAttributes[4]);
        int heightInCm = Integer.parseInt(childAttributes[5]);
        return new Child(id, gender, name, birthDay, weightInGrams, heightInCm);
    }

    private Gender assignGender(String line){
        char convertToChar = line.charAt(0);
        Gender gender = null;
        for (Gender readGender : Gender.values()) {
            if (readGender.getDescription() == convertToChar){
                gender = readGender;
            }
        }return gender;
    }
    private Mother findMotherById(List<Mother> mothers, int motherId) {
        Mother mother = null;
        for (Mother readMother : mothers) {
            if (readMother.getId() == motherId){
                mother = readMother;
            }
        }return mother;
    }

}
