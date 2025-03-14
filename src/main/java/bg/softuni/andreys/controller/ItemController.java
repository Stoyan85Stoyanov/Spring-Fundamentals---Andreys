package bg.softuni.andreys.controller;

import bg.softuni.andreys.config.UserSession;
import bg.softuni.andreys.dto.AddItemDto;
import bg.softuni.andreys.repository.UserRepository;
import bg.softuni.andreys.service.ItemService;
import bg.softuni.andreys.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;
    private final UserSession userSession;
    private final UserRepository userRepository;

    public ItemController(ItemService itemService, UserService userService, UserSession userSession, UserRepository userRepository) {
        this.itemService = itemService;
        this.userService = userService;
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    @ModelAttribute("itemData")
    public AddItemDto ItemData() {
        return new AddItemDto();
    }

    @GetMapping("/add-item")
    public String addItem() {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }
        return "add-item";
    }

    @PostMapping("/add-item")
    public String doAddItem(
            @Valid AddItemDto data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemData", bindingResult);

            return "redirect:/add-item";
        }

        boolean success = itemService.create(data);

        if (!success) {
            redirectAttributes.addFlashAttribute("itemData", data);

            return "redirect:/add-item";
        }

        return "redirect:/";
    }

//    // Delete button !!!
//    ("/albums/{id}")
//    public String deleteAlbum(@PathVariable String id) {
//        albumService.delete(id);
//        return "redirect:/home";
//    }



    // Delete button !!!
    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable String id) {
        itemService.delete(id);
        return "redirect:/details-item";
    }
}

