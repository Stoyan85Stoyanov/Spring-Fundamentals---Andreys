package bg.softuni.andreys.repository;
import bg.softuni.andreys.entity.Category;
import bg.softuni.andreys.entity.Item;
import bg.softuni.andreys.entity.User;
import bg.softuni.andreys.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, String> {

    Optional<Item> findByName(CategoryEnum name);

    List<Item> findAllByCategory(CategoryEnum name);

    @Query("SELECT i FROM Item i")
    List<Item> findAllItems();

    Optional<Item> findByIdAndCategory(String id, User category);
}
