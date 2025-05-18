package zadanieczwarte.model;

public class Kolo implements Figura {
    private int counterKolo;
    private double r;

    public Kolo(double r) {
        this.r = r;
        this.counterKolo = 0;
    }
    protected Kolo(double r, int counterAllFigury){
        this.r = r / 2;
        this.counterKolo = counterAllFigury;
    }

    public int getCounterKolo() {
        return counterKolo;
    }

    public void setCounterKolo(int counterKolo) {
        this.counterKolo = counterKolo;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI_NUMBER * r;
    }

    @Override
    public double calculateArea() {
        return PI_NUMBER * r * r;
    }

    @Override
    public String toString() {
        int castInt = (int) r;
        return "Figura nr: " + counterKolo + " Ko³o o promieniu " + castInt + ".";
    }
}
