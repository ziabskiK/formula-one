package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "scores", joinColumns = @JoinColumn(name = "race_id"), inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private List<Driver> drivers;

    public Race(String raceYear, String grandPrix) {
        this.raceYear = raceYear;
        this.grandPrix = grandPrix;
    }
}
