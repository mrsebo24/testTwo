package zadanieczwarte.model;

import java.util.Objects;

public class Kwadrat extends FiguraBazowa {
    private int counterKwadrat;
    private double a;

    public Kwadrat(double a) {
        this.a = a;
        this.counterKwadrat = 0;
    }
    protected Kwadrat(double a, int counterFigury){
        this.a = a;
        this.counterKwadrat = counterFigury;
    }

    public int getCounterKwadrat() {
        return counterKwadrat;
    }

    public void setCounterKwadrat(int counterKwadrat) {
        this.counterKwadrat = counterKwadrat;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return Double.compare(kwadrat.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        int castInt = (int) a;
        return "Figura nr: " + counterKwadrat + " Kwadrat o boku " + castInt + '.';
    }
}
