package zadanieczwarte.model;

import java.util.Objects;

public class Kwadrat extends Figura {

    private double a;

    public Kwadrat(double a) {
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

        return "Figura nr: " + getNumber() + " Kwadrat o boku " + a + '.';
    }
}
