package zadanieczwarte.service;

import zadanieczwarte.model.Figura;

import java.util.List;

public class Calculate {

    private List<Figura> figuraList;

    public Calculate(List<Figura> figuraList) {
        this.figuraList = figuraList;
    }

    public Figura getFiguraWithMaxPerimeter(){
        Figura result = null;
        double maxPerimeter = 0;
        for (Figura readFigura : figuraList) {
            if (readFigura.calculatePerimeter() > maxPerimeter){
                result = readFigura;
            }
        }return result;
    }

    public Figura getFiguraWithMaxArea(){
        Figura result = null;
        double maxArea = 0;
        for (Figura readFigura : figuraList) {
            if (readFigura.calculateArea() > maxArea){
                result = readFigura;
            }
        }return result;
    }
}
