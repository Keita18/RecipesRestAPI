package recipes.services;

import recipes.domain.Recipe;

interface RecipeService {
    Long saveRecipe(Recipe recipe);

    Recipe getRecipe(Long id);
}
