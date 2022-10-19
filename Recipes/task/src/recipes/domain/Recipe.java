package recipes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotEmpty
    private List<@NotBlank String> ingredients;
    @NotEmpty
    private List<@NotBlank String> directions;
}
