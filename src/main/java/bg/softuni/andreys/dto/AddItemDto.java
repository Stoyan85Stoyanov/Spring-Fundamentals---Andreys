package bg.softuni.andreys.dto;

import bg.softuni.andreys.entity.enums.CategoryEnum;
import bg.softuni.andreys.entity.enums.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddItemDto {

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 3)
    private String description;

    @Min(value = 0)
    private BigDecimal price;

    private CategoryEnum category;

    private Gender gender;
}
