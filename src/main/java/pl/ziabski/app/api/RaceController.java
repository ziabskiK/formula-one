package pl.ziabski.app.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ziabski.app.data_model.Race;
import pl.ziabski.app.service.RaceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceController {

    private RaceService service;

    public RaceController(RaceService service) {
        this.service = service;
    }

    @GetMapping("/race")
    public List<Race> getAllRaces(){
        return service.findAll();
    }
}
