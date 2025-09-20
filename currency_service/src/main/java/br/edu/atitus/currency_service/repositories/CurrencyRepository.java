package br.edu.atitus.currency_service.repositories;

import br.edu.atitus.currency_service.entities.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository
        extends JpaRepository<CurrencyEntity, Long> {

    Optional<CurrencyEntity> findBySourceAndTarget(String source, String target);

}
