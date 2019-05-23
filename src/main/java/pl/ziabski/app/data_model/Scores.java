package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Scores implements Serializable {




    @Id
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Id
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    private int points;



    public Scores(Driver driver, int points) {
        this.driver = driver;
        this.points = points;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Scores)) {
            return false;
        }
        Scores scores = (Scores) o;
        return getPoints() == scores.getPoints() &&
                Objects.equals(getDriver(), scores.getDriver()) &&
                Objects.equals(getRace(), scores.getRace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriver(), getRace(), getPoints());
    }
}
