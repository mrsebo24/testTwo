package zadanietrzecie.model;

//stanowisko, pensja
public class Employee extends Person {
    private String position;
    private double salary;

    private Employee(String firstName, String lastName, String pesel, String city, String position, double salary) {
        super(firstName, lastName, pesel, city);
        this.position = position;
        this.salary = salary;
    }

    public static Employee checkPeselAndReturnEmployee(String firstName, String lastName, String pesel, String city, String position, double salary){
        if (pesel.length() != 11){
            throw new IllegalStateException("Bad length pesel");
        }
        return new Employee(firstName, lastName, pesel, city, position, salary);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getIncome() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                " " + position +
                " " + salary;
    }
}
