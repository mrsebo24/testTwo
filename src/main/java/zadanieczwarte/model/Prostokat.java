package zadanieczwarte.model;

import java.util.Objects;

public class Prostokat implements Figura {
    private int counterProstokat;
    private double a;
    private double b;

    public Prostokat(double a, double b) {
        this.a = a;
        this.b = b;
        this.counterProstokat = 0;
    }

    protected Prostokat(double a, double b, int counterFigury){
        this.a = a;
        this.b = b;
        this.counterProstokat = counterFigury;
    }

    public int getCounterProstokat() {
        return counterProstokat;
    }

    public void setCounterProstokat(int counterProstokat) {
        this.counterProstokat = counterProstokat;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * a) + (2 * b);
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prostokat prostokat = (Prostokat) o;
        return counterProstokat == prostokat.counterProstokat && Double.compare(prostokat.a, a) == 0 && Double.compare(prostokat.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(counterProstokat, a, b);
    }

    @Override
    public String toString() {
        int convertA = (int) a;
        int convertB = (int) b;
        return "Figura nr: " + counterProstokat + " Prostokat o bokach " + convertA + "x" + convertB + ".";
    }
}
