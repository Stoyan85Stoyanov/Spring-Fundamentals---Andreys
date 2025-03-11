package bg.softuni.andreys.repository;

import bg.softuni.andreys.entity.Category;
import bg.softuni.andreys.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(CategoryEnum name);
}
