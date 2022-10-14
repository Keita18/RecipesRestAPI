package recipes.services;

import recipes.domain.Recipe;

interface RecipeService {
    void saveRecipe(Recipe recipe);

    Recipe getRecipe();
}
