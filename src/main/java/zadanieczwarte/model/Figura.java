package zadanieczwarte.model;

public interface Figura {

    double PI_NUMBER = 3.14;

    default double calculatePerimeter(){return 0;}
    default double calculateArea(){return 0;}

    static Kwadrat stworzKwadrat(double a) {
        return FiguraBazowa.stworzKwadrat(a);
    }

    static Prostokat stworzProstokat(double a, double b){
        return FiguraBazowa.stworzProstokat(a, b);
    }

    static Kolo stworzKolo(double r){
        return FiguraBazowa.stworzKolo(r);
    }
}

