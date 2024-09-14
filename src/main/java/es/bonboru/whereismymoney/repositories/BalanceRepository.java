package es.bonboru.wheredidmymoneygo.repositories;

import es.bonboru.wheredidmymoneygo.model.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {

}
