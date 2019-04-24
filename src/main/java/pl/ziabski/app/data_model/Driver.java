package pl.ziabski.app.data_model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String country;

    public Driver(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }




}
