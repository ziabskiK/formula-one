package pl.ziabski.app.service;

import org.springframework.stereotype.Service;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.repository.DriverRepository;

import java.util.List;

@Service
public class DriverServiceImplementation  {

    private DriverRepository repository;

    public DriverServiceImplementation(DriverRepository repository) {
        this.repository = repository;
    }


    public List<Driver> findAll() {
        return repository.findAll();
    }


    public Driver addNewDriver(Driver driver) {
        return repository.save(driver);
    }


    public void delete(int id) {
        repository.deleteById(id);
    }
}
