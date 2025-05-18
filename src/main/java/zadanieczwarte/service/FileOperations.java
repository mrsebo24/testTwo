package zadanieczwarte.service;

import zadanieczwarte.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations extends FiguraBazowa {

    public FileOperations() {
    }

    public void save(String fileName, List<Figura> figury){
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

    public List<Figura> readFigury(String fileName){
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

    private Figura readFigura(String line) {
        String[] elements = line.trim().split(" ");
        String counterNumberFigura = elements[2];
        String figuraClassName = elements[3];
        String numbersElement = elements[6];
        return findAndReturnFigura(counterNumberFigura, figuraClassName, numbersElement);
    }

    private Figura findAndReturnFigura(String counterNumberFigura, String figuraClassName, String numbersElement) {
        Figura result = null;
        if (figuraClassName.equals("Kwadrat")){
            result = getKwadrat(counterNumberFigura, numbersElement);
        }if (figuraClassName.equals("Ko³o")){
            result = getKolo(counterNumberFigura, numbersElement);
        }if(figuraClassName.equals("Prostokat")){
            result = getProstokat(counterNumberFigura, numbersElement);
        }
        return result;
    }

    private Prostokat getProstokat(String counterNumberFigura, String numbersElement) {
        Prostokat prostokat = getProstokat(numbersElement);
        prostokat.setCounterProstokat(Integer.parseInt(counterNumberFigura));
        return prostokat;
    }

    private Kolo getKolo(String counterNumberFigura, String numbersElement) {
        double r = getIntFromline(numbersElement);
        Kolo kolo = new Kolo(r);
        kolo.setCounterKolo(Integer.parseInt(counterNumberFigura));
        return kolo;
    }

    private Kwadrat getKwadrat(String counterNumberFigura, String numbersElement) {
        double a = getIntFromline(numbersElement);
        Kwadrat kwadrat = new Kwadrat(a);
        kwadrat.setCounterKwadrat(Integer.parseInt(counterNumberFigura));
        return kwadrat;
    }

    private Prostokat getProstokat(String numbersElement) {
        String[] elementsForProstokat = getElementsForProstokat(numbersElement);
        double a = parseNumber(elementsForProstokat[0]);
        double b = parseNumber(elementsForProstokat[1]);
        return Figura.stworzProstokat(a, b);
    }

    private double getIntFromline(String element){
        return parseNumber(element.replace(".", ""));
    }
    public String[] getElementsForProstokat(String element){
        return element.replace("x", " ")
                .replace(".", "")
                .split(" ");
    }

    private double parseNumber(String numberLine){
        return Double.parseDouble(numberLine);
    }
}
