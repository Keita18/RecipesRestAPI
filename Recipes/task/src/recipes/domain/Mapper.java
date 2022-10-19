package recipes.domain;

import org.springframework.stereotype.Component;
import recipes.domain.entity.DirectionEntity;
import recipes.domain.entity.IngredientEntity;
import recipes.domain.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class Mapper {

    public Recipe toRecipe(RecipeEntity recipeEntity) {
        List<String> directions = recipeEntity.getDirections().stream()
                .map(DirectionEntity::getName).collect(toList());
        List<String> ingredients = recipeEntity.getIngredients().stream()
                .map(IngredientEntity::getName).collect(toList());

        return new Recipe(
                recipeEntity.getName(),
                recipeEntity.getDescription(),
                ingredients,
                directions
                );
    }

    public RecipeEntity toEntity (Recipe recipe) {
        List<DirectionEntity> directions = new ArrayList<>();
        recipe.getDirections().forEach(it -> directions.add(new DirectionEntity(it)));

        List<IngredientEntity> ingredients = new ArrayList<>();
        recipe.getIngredients().forEach(it -> ingredients.add(new IngredientEntity(it)));

        return new RecipeEntity(
                recipe.getName(),
                recipe.getDescription(),
                ingredients,
                directions
        );
    }
}
