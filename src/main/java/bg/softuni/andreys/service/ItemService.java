package bg.softuni.andreys.service;

import bg.softuni.andreys.config.UserSession;
import bg.softuni.andreys.dto.AddItemDto;
import bg.softuni.andreys.entity.Category;
import bg.softuni.andreys.entity.Item;
import bg.softuni.andreys.entity.User;
import bg.softuni.andreys.entity.enums.CategoryEnum;
import bg.softuni.andreys.entity.enums.Gender;
import bg.softuni.andreys.repository.CategoryRepository;
import bg.softuni.andreys.repository.ItemRepository;
import bg.softuni.andreys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {

    private final UserService userService;
    private final UserSession userSession;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(UserService userService, UserSession userSession, UserRepository userRepository, ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.userSession = userSession;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public boolean create(AddItemDto data) {

        if (!userSession.isLoggedIn()) {
            return false;
        }

        Optional<User> byId = userRepository.findById(userSession.id());

        if (byId.isEmpty()) {
            return false;
        }

        Optional<Category> byName = categoryRepository.findByName(data.getCategory());

        if (byName.isEmpty()) {
            return false;
        }

        Item item = new Item();
        item.setName(data.getName());
        item.setDescription(data.getDescription());
        item.setCategory(byName.get());
        item.setGender(data.getGender());
        item.setPrice(data.getPrice());

        itemRepository.save(item);
        return true;
    }

    public Map<CategoryEnum, List<Item>> findAllByCategory() {
        Map<CategoryEnum, List<Item>> result = new HashMap<>();

        List<Category> allCategories = categoryRepository.findAll();
        // th:each = "cocktail: ${cocktailsData}">
        for (Category category : allCategories) {
            List<Item> items = itemRepository.findAllByCategory(category.getName());
            result.put(category.getName(), items);
        }

        return result;
    }

    public List<Item> listItems(){
        return itemRepository.findAllItems();
    }


    public void delete(String id) {
//        Optional<User> category = userRepository.findById(userSession.id());
//
//        if (category.isEmpty()) {
//            return;
//        }
//        Optional<Item> mayBeItem = itemRepository.findByIdAndCategory(id, category.get());
//
//        if (mayBeItem.isEmpty()) {
//            return;
//        }
        itemRepository.deleteById(id);
    }
}
