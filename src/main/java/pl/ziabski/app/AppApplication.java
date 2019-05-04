package pl.ziabski.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.data_model.Race;
import pl.ziabski.app.data_model.Scores;
import pl.ziabski.app.service.DriverServiceImplementation;
import pl.ziabski.app.service.RaceService;
import pl.ziabski.app.service.ScoresService;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories( basePackages = "pl.ziabski.app.repository")
public class AppApplication {

    @Autowired
    public AppApplication(EntityManager em) {
        this.em = em;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    private final EntityManager em;

    @Bean
    CommandLineRunner runner(@Autowired DriverServiceImplementation repository, @Autowired RaceService raceService, @Autowired ScoresService scoresService) {
        /**
         * Create BufferedReaders for data files. Create new database rows.
         *
         * @return
         * New Driver POJO
         * New Race POJO
         *
         */

        return args -> {
            try (BufferedReader driversReader = new BufferedReader(new FileReader("Drivers.txt"));
                    BufferedReader raceReader = new BufferedReader(new FileReader("Races.txt"));
                    BufferedReader scoresReader = new BufferedReader(new FileReader("Scores.txt"))) {
                driversReader.lines().forEach(line -> {
                    String[] driver = line.split(";");
                    repository.createOrUpdate(new Driver(driver[1], driver[2], driver[3]));
                });
                raceReader.lines().forEach(line -> {
                    String[] races = line.split(";");
                    raceService.createOrUpdate(new Race(races[1],races[2]));

                });
                scoresReader.lines().forEach(line ->{

                    int[] scores = Stream.of(line.split(";")).mapToInt(Integer::parseInt).toArray();

                    em.unwrap(Scores.class).setDriver_id(scores[0]);
                    em.unwrap(Scores.class).setDriver_id(scores[1]);
                    em.unwrap(Scores.class).setDriver_id(scores[2]);




                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        };
    }



}
