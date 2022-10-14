package recipes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.domain.Recipe;
import recipes.repo.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(@Autowired RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        recipeRepository.add(recipe);
    }

    @Override
    public Recipe getRecipe() {
        return recipeRepository.get();
    }
}
