package bg.softuni.andreys.dto;

import bg.softuni.andreys.entity.Category;
import bg.softuni.andreys.entity.Item;
import bg.softuni.andreys.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemInfoDto {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private Gender gender;
}
