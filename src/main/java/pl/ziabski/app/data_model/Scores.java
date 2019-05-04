package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Table(name = "scores")
public class Scores {

    @Column(name = "driver_id")
    private int driver_id;

    @Column(name = "race_id")
    private int race_id;

    private int points;


    public Scores(int driver_id, int race_id, int points) {
        this.driver_id = driver_id;
        this.race_id = race_id;
        this.points = points;
    }
}
