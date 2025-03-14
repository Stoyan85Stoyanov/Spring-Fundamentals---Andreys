package bg.softuni.andreys.init;

import bg.softuni.andreys.entity.Category;
import bg.softuni.andreys.entity.enums.CategoryEnum;
import bg.softuni.andreys.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class InitService implements CommandLineRunner {

    private final Map<CategoryEnum, String> description = Map.of(
            CategoryEnum.Shirt, "Description for Shirt",
            CategoryEnum.Denim, "Description for Denim",
            CategoryEnum.Shorts, "Description for Shorts",
            CategoryEnum.Jacket, "Description for Jacket" );

    private final CategoryRepository categoryRepository;

    public InitService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long count = this.categoryRepository.count();

        if (count > 0) {
            return;
        }
        List<Category> toInsert = Arrays.stream(CategoryEnum.values())
                .map(name -> new Category(name, description.get(name))).toList();

        this.categoryRepository.saveAll(toInsert);

    }
}
