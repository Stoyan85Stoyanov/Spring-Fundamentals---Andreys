package bg.softuni.andreys.entity;

import bg.softuni.andreys.entity.enums.Gender;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(unique = true)
    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne(optional = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Item() {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
