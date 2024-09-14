package es.bonboru.wheredidmymoneygo.repositories;

import es.bonboru.wheredidmymoneygo.model.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementsRepository extends JpaRepository<MovementEntity, Long> {

    @Query("SELECT m FROM MovementEntity m WHERE FUNCTION('YEAR', m.dateCreation) = :year AND FUNCTION('MONTH', m.dateCreation) = :month")
    List<MovementEntity> findByYearAndMonth(@Param("year") String year, @Param("month") String month);

}
