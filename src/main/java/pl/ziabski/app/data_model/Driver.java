package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private int id;

    private String firstName;

    private String lastName;

    private String country;

    @OneToMany(mappedBy = "driver")
    Set<RaceScores> points;

    public Driver(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }




}
