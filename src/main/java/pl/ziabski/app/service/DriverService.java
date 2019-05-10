package pl.ziabski.app.service;

import org.springframework.stereotype.Service;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.repository.DriverRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DriverServiceImplementation {

    private DriverRepository repository;

    public DriverServiceImplementation(DriverRepository repository) {
        this.repository = repository;
    }


    public List<Driver> findAll() {
        return repository.findAll();
    }


    public Driver createOrUpdate(Driver driver) {
        return repository.save(driver);
    }


    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Could not find driver ID: " + id);


        }

    }

    public Optional<Driver> findDriverById(int id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id);
        } else {
            throw new RuntimeException("Could not find driver ID: " + id);
        }
    }


}
