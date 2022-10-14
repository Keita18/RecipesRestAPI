package recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
import recipes.services.RecipeServiceImpl;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private final RecipeServiceImpl service;

    public RecipeController(@Autowired RecipeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/recipe")
    public ResponseEntity<Recipe> getRecipe() {
        return ResponseEntity.ok().body(service.getRecipe());
    }

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        service.saveRecipe(recipe);
        return ResponseEntity.ok().build();
    }
}
