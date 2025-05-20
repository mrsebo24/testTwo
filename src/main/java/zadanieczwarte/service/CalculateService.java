package zadanieczwarte.service;

import zadanieczwarte.model.Figura;

import java.util.List;

public class CalculateService {

    private List<Figura> figuraList;

    public CalculateService(List<Figura> figuraList) {
        this.figuraList = figuraList;
    }

    public Figura getFiguraWithMaxPerimeter(){
        Figura result = null;
        double maxPerimeter = 0;
        for (Figura f : figuraList) {
            if (f.calculatePerimeter() > maxPerimeter){
                result = f;
            }
        }return result;
    }

    public Figura getFiguraWithMaxArea(){
        Figura result = null;
        double maxArea = 0;
        for (Figura f : figuraList) {
            if (f.calculateArea() > maxArea){
                result = f;
            }
        }return result;
    }
}
