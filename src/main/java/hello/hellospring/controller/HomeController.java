package hello.hellospring.controller;


import hello.hellospring.domain.MenuList;
import hello.hellospring.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("") // localhost:8080이 들어오면
    public String home(Model model) {

        List<MenuList> menus = homeService.getMenuList();
        model.addAttribute("menus", menus);

        return "home/home";
    }
}
