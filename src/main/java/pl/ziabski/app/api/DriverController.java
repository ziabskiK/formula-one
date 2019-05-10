package pl.ziabski.app.api;


import org.springframework.web.bind.annotation.*;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.service.DriverService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DriverController {



    private DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping("/driver")
    public List<Driver> getDrivers(){
        return service.findAll();
    }

    @PostMapping(value = "/driver", consumes = "application/json", produces = "application/json")
    public Driver addNewDriver(@RequestBody Driver d){
         return service.createOrUpdate(d);
    }

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.DELETE)
    public void deleteDriver(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("/driver/{id}")
    public Optional<Driver> findDriverById(@PathVariable int id){
        return service.findDriverById(id);
    }

    @PutMapping("/driver/{id}")
    public Driver updateDriver(@PathVariable int id, @RequestBody Driver driver){
        return service.findDriverById(id).map(driver1 -> {
            driver1.setFirstName(driver.getFirstName());
            driver1.setLastName(driver.getLastName());
            driver1.setCountry(driver.getCountry());
            return service.createOrUpdate(driver1);
        }).orElseGet(() -> {
            driver.setId(id);
            return service.createOrUpdate(driver);
        });
    }


}
