package pl.ziabski.app.service;

import org.springframework.stereotype.Service;
import pl.ziabski.app.data_model.RaceScores;
import pl.ziabski.app.data_model.Scores;
import pl.ziabski.app.repository.ScoreRepository;

@Service
public class ScoresService {

    private ScoreRepository scoreRepository;

    public ScoresService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }
    public RaceScores createOrUpdate(RaceScores a){
        return scoreRepository.save(a);
    }
}
