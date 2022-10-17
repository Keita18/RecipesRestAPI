package recipes.repo;

import org.springframework.stereotype.Repository;
import recipes.domain.Recipe;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {
    private final Map<Long, Recipe> recipeList = new HashMap<>();
    private Long id = 0L;

    @Override
    public Recipe getRecipe(Long id) {
        return recipeList.get(id);
    }

    @Override
    public Long add(Recipe recipe) {
        id++;
        Recipe _recipe = new Recipe(
                recipe.getName(),
                recipe.getDescription(),
                recipe.getIngredients(),
                recipe.getDirections());
        recipeList.put(id, _recipe);
        return id;
    }
}
