package zadanieczwarte.model;

import java.util.Objects;

public class Prostokat extends Figura {
    private double a;
    private double b;

    public Prostokat(double a, double b) {
        this.a = a;
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
        return Double.compare(prostokat.a, a) == 0 && Double.compare(prostokat.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {

        return "Figura nr: " + getNumber() + " Prostokat o bokach " + a + "x" + b + ".";
    }
}
