package pl.ziabski.app.data_model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RaceScores {
    @EmbeddedId
    private DriverRaceKey id;

    @ManyToOne
    @MapsId("race_id")
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @MapsId("driver_id")
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private int points;

    public RaceScores(Race race, Driver driver, int points) {
        this.race = race;
        this.driver = driver;
        this.points = points;
    }
}
