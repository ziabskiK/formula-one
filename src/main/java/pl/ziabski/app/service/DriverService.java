package pl.ziabski.app.service;

import org.springframework.stereotype.Service;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.repository.DriverRepository;

import java.util.List;


public interface DriverService {




    List<Driver> findAll();


    Driver addNewDriver(Driver driver);


    void delete(int id);


}
