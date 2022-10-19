package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.domain.Recipe;
import recipes.domain.entity.RecipeEntity;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Long> {
}
