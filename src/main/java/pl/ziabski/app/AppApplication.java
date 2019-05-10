package pl.ziabski.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.data_model.Race;
import pl.ziabski.app.data_model.RaceScores;
import pl.ziabski.app.service.DriverService;
import pl.ziabski.app.service.RaceService;
import pl.ziabski.app.service.ScoresService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.ziabski.app.repository")
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }


    /**
     * Create BufferedReaders for data files. Create new database rows.
     *
     * @return New Driver POJO
     * New Race POJO
     */
    @Bean
    CommandLineRunner runner(@Autowired DriverService repository, @Autowired RaceService raceService, @Autowired ScoresService scoresService) {

        return args -> {
            try (BufferedReader driversReader = new BufferedReader(new FileReader("Drivers.txt"));
                 BufferedReader raceReader = new BufferedReader(new FileReader("Races.txt"));
                 BufferedReader scoresReader = new BufferedReader(new FileReader("Scores.txt"))) {

                driversReader.lines().forEach(line -> {
                    String[] driver = line.split(";");
                    Driver newDriver = new Driver(driver[1], driver[2], driver[3]);
                    repository.createOrUpdate(newDriver);

                });
                raceReader.lines().forEach(line -> {
                    String[] races = line.split(";");
                    Race newRace = new Race(races[1], races[2]);
                    raceService.createOrUpdate(newRace);
                });
                scoresReader.lines().forEach(line -> {

                    int[] scores = Stream.of(line.split(";")).mapToInt(Integer::parseInt).toArray();

                    RaceScores r = new RaceScores(scores[0], scores[1], scores[2]);

                    scoresService.createOrUpdate(r);
                });


            } catch (IOException e) {
                e.printStackTrace();
            }

        };
    }


}
