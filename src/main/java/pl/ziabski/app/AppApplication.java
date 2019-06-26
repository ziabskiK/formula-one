package pl.ziabski.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.repository.DriverRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    CommandLineRunner runner(@Autowired DriverRepository driverService) {

        return args -> {
//
            try(BufferedReader driversReader = new BufferedReader(new FileReader("Drivers.txt"))){
                driversReader.lines().forEach(line -> {
                    String[] driver = line.split(";");
                    Driver newDriver = new Driver(driver[1], driver[2], driver[3]);
                    driverService.save(newDriver);
                });
            } catch (IOException e){
                System.out.println(e.getMessage());
            }



        };
    }


}
