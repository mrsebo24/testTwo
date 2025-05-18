package zadaniepierwsze.model;

import java.time.DayOfWeek;
import java.util.Objects;

public class MostPopularBirthdayAndNumberOfChildren {
    private DayOfWeek dayOfWeek;
    private int childrenBirthCounter;

    public MostPopularBirthdayAndNumberOfChildren(DayOfWeek dayOfWeek, int childrenBirthCounter) {
        this.dayOfWeek = dayOfWeek;
        this.childrenBirthCounter = childrenBirthCounter;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getChildrenBirthCounter() {
        return childrenBirthCounter;
    }

    public void setChildrenBirthCounter(int childrenBirthCounter) {
        this.childrenBirthCounter = childrenBirthCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MostPopularBirthdayAndNumberOfChildren that = (MostPopularBirthdayAndNumberOfChildren) o;
        return childrenBirthCounter == that.childrenBirthCounter && dayOfWeek == that.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, childrenBirthCounter);
    }

    @Override
    public String toString() {
        return "MostPopularDayAndNumberBirthChildren{" +
                "dayOfWeek=" + dayOfWeek +
                ", childrenBirthCounter=" + childrenBirthCounter +
                '}';
    }
}
