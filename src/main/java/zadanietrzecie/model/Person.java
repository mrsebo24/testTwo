package zadanietrzecie.model;
//(imie, nazwisko, pesel, miasto)
public abstract class Person {
    private String firstName;
    private String LastName;
    private String pesel;
    private String city;

    public Person(String firstName, String lastName, String pesel, String city) {
        this.firstName = firstName;
        LastName = lastName;
        this.pesel = pesel;
        this.city = city;
    }

    public Gender getGender(){
        if (Integer.parseInt(pesel.substring(10, 11)) % 2 != 0){
            return Gender.MAN;
        }
        else return Gender.WOMEN;
    }

    public abstract double getIncome();


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + firstName + " " + LastName + " " + pesel + " " + city;
    }
}
