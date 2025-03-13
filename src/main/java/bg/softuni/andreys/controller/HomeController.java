package bg.softuni.andreys.controller;

import bg.softuni.andreys.config.UserSession;
import bg.softuni.andreys.dto.ItemInfoDto;
import bg.softuni.andreys.service.ItemService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final UserSession userSession;
    private final ItemService itemService;

    public HomeController(UserSession userSession, ItemService itemService) {
        this.userSession = userSession;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String nonLoggedIndex() {
        if(userSession.isLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    @Transactional
    public String loggedInIndex(Model model) {
        if(!userSession.isLoggedIn()) {
            return "redirect:/";
        }
        List<ItemInfoDto> allItems = itemService.listItems().stream().map(ItemInfoDto::new).toList();

        model.addAttribute("allItems", allItems);

//        int sum = 0;
//        for (ItemInfoDto item : allItems) {
//            sum += Integer.parseInt(item.getCategory().getId());
//        }

        model.addAttribute("sum", allItems.size());
        return "home";
    }

    @GetMapping("/details-item")
    @Transactional
    public String loggedInIndexDetails(Model model) {
        if(!userSession.isLoggedIn()) {
            return "redirect:/home";
        }
        List<ItemInfoDto> allItems = itemService.listItems().stream().map(ItemInfoDto::new).toList();

        model.addAttribute("allItems", allItems);

//        int sum = 0;
//        for (ItemInfoDto item : allItems) {
//            sum += Integer.parseInt(item.getCategory().getId());
//        }

//        model.addAttribute("sum", allItems.size());
        return "details-item";
    }
}
