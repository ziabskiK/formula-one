package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String raceYear;

    private String grandPrix;

    @OneToMany(mappedBy = "race")
    Set<RaceScores> points;

    public Race(String raceYear, String grandPrix) {
        this.raceYear = raceYear;
        this.grandPrix = grandPrix;
    }
}
