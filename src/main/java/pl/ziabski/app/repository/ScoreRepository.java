package pl.ziabski.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ziabski.app.data_model.Race;
import pl.ziabski.app.data_model.Scores;

@Repository
public interface ScoreRepository extends JpaRepository<Scores, Integer> {
}
