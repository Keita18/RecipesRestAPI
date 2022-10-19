package recipes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.domain.Mapper;
import recipes.domain.Recipe;
import recipes.domain.entity.DirectionEntity;
import recipes.domain.entity.RecipeEntity;
import recipes.repository.RecipeRepository;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final Mapper mapper;

    public RecipeServiceImpl(@Autowired RecipeRepository recipeRepository, Mapper mapper) {
        this.recipeRepository = recipeRepository;
        this.mapper = mapper;
    }

    public boolean existRecipe(final Long id) {
        return recipeRepository.existsById(id);
    }

    @Override
    public Long saveRecipe(final Recipe recipe) {
        var entity = mapper.toEntity(recipe);
        return recipeRepository.save(entity).getId();
    }

    @Override
    public Recipe getRecipe(final Long id) {
        var recipe = recipeRepository.findById(id);
        return recipe.map(mapper::toRecipe).orElse(null);
    }

    @Override
    public void deleteRecipe(final long id) {
        recipeRepository.deleteById(id);
    }
}
