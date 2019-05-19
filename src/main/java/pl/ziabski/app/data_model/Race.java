package pl.ziabski.app.data_model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "race_year")
    private String raceYear;

    @Column(name = "grand_prix")
    private String grandPrix;

    public Race(String raceYear, String grandPrix) {
        this.raceYear = raceYear;
        this.grandPrix = grandPrix;
    }
}
