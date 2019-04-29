package pl.ziabski.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.service.DriverServiceImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories( basePackages = "pl.ziabski.app.repository")
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(@Autowired DriverServiceImplementation repository) {
        return args -> {
            try (BufferedReader br = new BufferedReader(new FileReader("Kierowcy.txt"))) {
                br.lines().forEach(line -> {
                    String[] driver = line.split(";");
                    repository.createOrUpdate(new Driver(driver[1], driver[2], driver[3]));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        };
    }


}
