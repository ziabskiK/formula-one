package pl.ziabski.app.service;

import org.springframework.stereotype.Service;
import pl.ziabski.app.data_model.Race;
import pl.ziabski.app.repository.RaceRepository;

import java.util.List;

@Service
public class RaceService {

    private RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> findAll(){
        return raceRepository.findAll();
    }
    public Race createOrUpdate(Race race){
        return  raceRepository.save(race);
    }
}
