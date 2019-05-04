package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String raceYear;

    private String grandPrix;

    public Race(String raceYear, String grandPrix) {

        this.raceYear = raceYear;
        this.grandPrix = grandPrix;
    }
}
