package recipes.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private List<IngredientEntity> ingredients;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "direction_id", nullable = false)
    private List<DirectionEntity> directions;

    public RecipeEntity() {}

    public RecipeEntity(String name, String description, List<IngredientEntity> ingredients, List<DirectionEntity> directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public List<DirectionEntity> getDirections() {
        return directions;
    }

    public void setDirections(List<DirectionEntity> directions) {
        this.directions = directions;
    }
}
