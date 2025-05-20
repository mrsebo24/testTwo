package zadanieczwarte.model;

import java.util.Objects;

public class Kolo extends Figura {

    private double r;


    public Kolo(double r) {
        this.r = r;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public double calculateArea() {
        return Math.PI * r * r;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolo kolo = (Kolo) o;
        return Double.compare(kolo.r, r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r);
    }

    @Override
    public String toString() {

        return "Figura nr: " + getNumber() + " Ko³o o promieniu " + r + ".";
    }
}
