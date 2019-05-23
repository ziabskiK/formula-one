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
import pl.ziabski.app.repository.DriverRepository;
import pl.ziabski.app.repository.RaceRepository;

import java.util.Arrays;

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
    CommandLineRunner runner(@Autowired DriverRepository driverService, @Autowired RaceRepository raceService) {

        return args -> {
//            try (BufferedReader driversReader = new BufferedReader(new FileReader("Drivers.txt"));
//                 BufferedReader raceReader = new BufferedReader(new FileReader("Races.txt"));
//                 BufferedReader scoresReader = new BufferedReader(new FileReader("Scores.txt"))) {
//
//                driversReader.lines().forEach(line -> {
//                    String[] driver = line.split(";");
//                    Driver newDriver = new Driver(driver[1], driver[2], driver[3]);
//                    repository.createOrUpdate(newDriver);
//
//                });
//                raceReader.lines().forEach(line -> {
//                    String[] races = line.split(";");
//                    Race newRace = new Race(races[1], races[2]);
//                    raceService.createOrUpdate(newRace);
//                });
//                scoresReader.lines().forEach(line -> {
//
//                    int[] scores = Stream.of(line.split(";")).mapToInt(Integer::parseInt).toArray();
//
//                    ScoresId r = new ScoresId(scores[0], scores[1], scores[2]);
//
//                    scoresService.createOrUpdate(r);
//                });



//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            Driver driverA =  new Driver("Lewis", "Hamilton", "GB");
            Driver driverB = new Driver("Fernando", "Alonso", "Spain");

            driverService.saveAll(Arrays.asList(driverA, driverB));

            raceService.save(new Race("2018", "Monaco", new Scores(driverA,10 ), new Scores(driverB, 5)));
            raceService.save(new Race("2017", "Spain", new Scores(driverA, 25), new Scores(driverB, 17)));





        };
    }


}
