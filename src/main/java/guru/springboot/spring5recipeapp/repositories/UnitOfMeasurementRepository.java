package guru.springboot.spring5recipeapp.repositories;

import guru.springboot.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Darshana Welikala on 2019-02-23.
 */
public interface UnitOfMeasurementRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
