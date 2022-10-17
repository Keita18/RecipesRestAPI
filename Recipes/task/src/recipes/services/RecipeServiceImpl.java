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
    public Long saveRecipe(Recipe recipe) {
        return recipeRepository.add(recipe);
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.getRecipe(id);
    }
}
