package pl.ziabski.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ziabski.app.data_model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer > {

}
