package zadanieczwarte.model;

public abstract class FiguraBazowa implements Figura {
    private static int ADD_COUNTER_FIGURY = 1;
    private static int counterFigury;

    public static Kwadrat stworzKwadrat(double a){
        return new Kwadrat(a, getAnotherNumberFigury());
    }
    public static Prostokat stworzProstokat(double a, double b){
        return new Prostokat(a, b, getAnotherNumberFigury());
    }
    public static Kolo stworzKolo(double r){
        return new Kolo(r, getAnotherNumberFigury());
    }
    private static int getAnotherNumberFigury() {
        return counterFigury += ADD_COUNTER_FIGURY;
    }

}
