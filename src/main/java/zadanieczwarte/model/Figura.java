package zadanieczwarte.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Figura {
    private static int COUNTER = 0;

    private int number;

    public Figura() {
    }

    public int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    public static Kwadrat stworzKwadrat(double a){
        Kwadrat kwadrat = new Kwadrat(a);
        ((Figura)kwadrat).setNumber(++COUNTER);
        return kwadrat;
    }
    public static Prostokat stworzProstokat(double a, double b){
        Prostokat prostokat = new Prostokat(a, b);
        ((Figura)prostokat).setNumber(++COUNTER);
        return prostokat;
    }
    public static Kolo stworzKolo(double r){
        Kolo kolo = new Kolo(r);
        ((Figura)kolo).setNumber(++COUNTER);
        return kolo;
    }


    public abstract double calculatePerimeter();


    public abstract double calculateArea();

    public static void save(String fileName, List<Figura> figury){
        try (
                PrintWriter save = new PrintWriter(fileName)
        ){
            for (Figura readFigury : figury) {
                save.println(readFigury);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    public static List<Figura> readFigury(String fileName){
        List<Figura> resultList = new ArrayList<>();
        try (
                Scanner reader = new Scanner(new File(fileName))
        ){
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                if (readFigura(line) != null){
                    Figura figura = readFigura(line);
                    resultList.add(figura);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }return resultList;
    }

    private static Figura readFigura(String line) {
        String[] elements = line.trim().split(" ");
        String figuraCounter = elements[2];
        String figuraClassName = elements[3];
        String numbersElement = elements[6];
        return findAndReturnFigura(figuraCounter, figuraClassName, numbersElement);
    }

    private static Figura findAndReturnFigura(String figuraCounter, String figuraClassName, String numbersElement) {
        Figura result = null;
        if (figuraClassName.equals("Kwadrat")){
            result = getKwadrat(figuraCounter, numbersElement);
        }if (figuraClassName.equals("Ko³o")){
            result = getKolo(figuraCounter, numbersElement);
        }if(figuraClassName.equals("Prostokat")){
            result = getProstokat(figuraCounter, numbersElement);
        }
        return result;
    }

    private static Kolo getKolo(String figuraCounter, String numbersElement) {
        Kolo kolo = new Kolo(parseNumber(numbersElement.trim().replaceAll("\\.+$", "")));
        ((Figura)kolo).setNumber(Integer.parseInt(figuraCounter));
        return kolo;
    }

    private static Kwadrat getKwadrat(String figuraCounter, String numbersElement) {
        Kwadrat kwadrat = new Kwadrat(Double.parseDouble(numbersElement.trim().replaceAll("\\.+$", "")));
        ((Figura)kwadrat).setNumber(Integer.parseInt(figuraCounter));
        return kwadrat;
    }

    private static Prostokat getProstokat(String figuraCounter, String numbersElement) {
        String[] elementsForProstokat = getElementsForProstokat(numbersElement);
        double a = parseNumber(elementsForProstokat[0]);
        double b = parseNumber(elementsForProstokat[1]);
        Prostokat prostokat = new Prostokat(a, b);
        ((Figura)prostokat).setNumber(Integer.parseInt(figuraCounter));
        return prostokat;
    }

    private static String[] getElementsForProstokat(String element){
        if (element.endsWith(".")) {
            element = element.substring(0, element.length() - 1);
        }
        return element.split("x");
    }

    private static double parseNumber(String numberLine){
        return Double.parseDouble(numberLine);
    }

}
