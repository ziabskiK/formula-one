package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RaceScores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "driver_id")
    private int driver_id;

    @Column(name = "race_id")
    private int race_id;

    private int points;

    public RaceScores(int driver_id, int race_id, int points) {
        this.driver_id = driver_id;
        this.race_id = race_id;
        this.points = points;
    }
}
