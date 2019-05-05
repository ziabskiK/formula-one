package pl.ziabski.app.data_model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class DriverRaceKey implements Serializable {

    @Column(name = "race_id")
    private int raceId;

    @Column(name = "driver_id")
    private int driverId;


}
