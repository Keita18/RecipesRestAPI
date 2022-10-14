package recipes.repo;

import recipes.domain.Recipe;

public interface RecipeRepository {
    Recipe get();

    void add(Recipe recipe);
}
