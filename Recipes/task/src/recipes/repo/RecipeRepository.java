package recipes.repo;

import recipes.domain.Recipe;

public interface RecipeRepository {
    Recipe getRecipe(Long id);

    Long add(Recipe recipe);
}
