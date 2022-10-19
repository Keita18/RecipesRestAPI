package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.domain.entity.IngredientEntity;

public interface IngredientRepository extends CrudRepository<IngredientEntity, Long> {
}
