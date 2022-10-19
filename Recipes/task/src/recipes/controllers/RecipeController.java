package recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
import recipes.services.RecipeServiceImpl;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeServiceImpl service;

    public RecipeController(@Autowired RecipeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable final Long id) {
        Recipe recipe = service.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(recipe);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> addRecipe(@Valid @RequestBody Recipe recipe) {
        System.out.println(recipe.toString());
        Long id = service.saveRecipe(recipe);
        return ResponseEntity.ok().body(Map.of("id", id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable final Long id) {
        boolean existRecipe = service.existRecipe(id);
        if (!existRecipe) {
            return ResponseEntity.notFound().build();
        }
        service.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}
