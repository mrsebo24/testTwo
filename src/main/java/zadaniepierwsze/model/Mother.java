package zadaniepierwsze.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mother extends Person {
    private int age;
    private List<Child> children;

    public Mother(int id, String imie, int age) {
        super(id, imie);
        this.age = age;
        this.children = new ArrayList<>();
    }

    @Override
    public String getInfo() {
        return getId() + " " + getFirstName() + " " + age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChildren(Child child){
        children.add(child);
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mother mother = (Mother) o;
        return age == mother.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }



    @Override
    public String toString() {
        return super.toString() +
                ", age=" + age +
                '}';
    }
}
