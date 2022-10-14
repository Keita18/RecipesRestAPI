package recipes.repo;

import org.springframework.stereotype.Repository;
import recipes.domain.Recipe;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {
    private Recipe recipe = new Recipe();

    @Override
    public Recipe get() {
        return recipe;
    }

    @Override
    public void add(Recipe recipe) {
        this.recipe = new Recipe(
                recipe.getName(),
                recipe.getDescription(),
                recipe.getIngredients(),
                recipe.getDirections());
    }
}
