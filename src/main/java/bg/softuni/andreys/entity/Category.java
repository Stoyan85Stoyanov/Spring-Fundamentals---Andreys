package bg.softuni.andreys.entity;

import bg.softuni.andreys.entity.enums.CategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
