package bg.softuni.andreys.entity;

import bg.softuni.andreys.entity.enums.CategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    private String description;


    public Category() {
    }

    public Category(CategoryEnum name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
