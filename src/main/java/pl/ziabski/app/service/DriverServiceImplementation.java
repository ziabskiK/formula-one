package pl.ziabski.app.service;

import org.springframework.stereotype.Service;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.repository.DriverRepository;

import java.util.List;

@Service
public class DriverServiceImplementation implements DriverService {

    private DriverRepository repository;

    public DriverServiceImplementation(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Driver> findAll() {
        return repository.findAll();
    }

    @Override
    public Driver addNewDriver(Driver driver) {
        return repository.save(driver);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
