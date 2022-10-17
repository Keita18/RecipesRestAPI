package recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
import recipes.services.RecipeServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private final RecipeServiceImpl service;

    public RecipeController(@Autowired RecipeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable final Long id) {
        Recipe recipe = service.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(recipe);
    }

    @PostMapping("/recipe/new")
    public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe) {
        System.out.println(recipe.toString());
        Long id = service.saveRecipe(recipe);
        return ResponseEntity.ok().body(Map.of("id", id));
    }
}
