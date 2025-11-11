package bg.softuni.andreys.controller;

import bg.softuni.andreys.config.UserSession;
import bg.softuni.andreys.dto.AddItemDto;
import bg.softuni.andreys.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final UserSession userSession;

    public ItemController(ItemService itemService, UserSession userSession) {
        this.itemService = itemService;
        this.userSession = userSession;
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

    // Delete button !!!
    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable String id) {
        itemService.delete(id);
        return "redirect:/details-item";
    }
}

