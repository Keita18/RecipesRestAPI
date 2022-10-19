package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.domain.entity.DirectionEntity;

public interface DirectionRepository extends CrudRepository<DirectionEntity, Long> {
}
