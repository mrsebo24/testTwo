package zadanietrzecie.model;

//grupa, stypendium)
public class Student extends Person {
    private String group;
    private double scholarship;

    private Student(String firstName, String lastName, String pesel, String city, String group, double scholarship) {
        super(firstName, lastName, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    public static Student checkPeselAndReturnStudent(String firstName, String lastName, String pesel, String city, String group, double scholarship){
        if (pesel.length() != 11){
            throw new IllegalStateException("zla ldugosc peselu");
        }
        return new Student(firstName, lastName, pesel, city, group, scholarship);
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public double getIncome() {
        return scholarship;
    }

    @Override
    public String toString() {
        return super.toString() +
                " " + group +
                " " + scholarship;
    }
}
