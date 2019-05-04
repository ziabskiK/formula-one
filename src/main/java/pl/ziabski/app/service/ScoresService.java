package pl.ziabski.app.service;

import org.springframework.stereotype.Service;
import pl.ziabski.app.data_model.Scores;
import pl.ziabski.app.repository.ScoreRepository;

@Service
public class ScoresService {

    private ScoreRepository scoreRepository;

    public ScoresService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }
    public Scores createOrUpdate(Scores a){
        return scoreRepository.save(a);
    }
}
