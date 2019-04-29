package pl.ziabski.app.api;


import org.springframework.web.bind.annotation.*;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.service.DriverServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverController {


    private DriverServiceImplementation service;

    public DriverController(DriverServiceImplementation service) {
        this.service = service;
    }

    @GetMapping("/driver")
    public List<Driver> getDrivers(){
        return service.findAll();
    }

    @PostMapping(value = "/driver", consumes = "application/json", produces = "application/json")
    public Driver addNewDriver(@RequestBody Driver d){
         return service.addNewDriver(d);
    }

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.DELETE)
    public void deleteDriver(@PathVariable int id){
        service.delete(id);
    }

}
