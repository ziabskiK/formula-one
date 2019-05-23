package pl.ziabski.app.data_model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@NoArgsConstructor
@Data
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "race_year")
    private String raceYear;

    @Column(name = "grand_prix")
    private String grandPrix;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private Set<Scores> scores;


    public Race(String raceYear, String grandPrix, Scores... scores) {
        this.raceYear = raceYear;
        this.grandPrix = grandPrix;
        for(Scores score: scores) {
            score.setRace(this);
        }
        this.scores = Stream.of(scores).collect(Collectors.toSet());
    }
}
