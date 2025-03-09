package bg.softuni.andreys.dto;

import bg.softuni.andreys.entity.enums.CategoryEnum;
import bg.softuni.andreys.entity.enums.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

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


    public AddItemDto() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
