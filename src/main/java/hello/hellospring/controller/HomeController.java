package hello.hellospring.controller;


import hello.hellospring.domain.HomeChallenge;
import hello.hellospring.domain.MenuList;
import hello.hellospring.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home") // home페이지
    public String home(Model model) {

        List<HomeChallenge> homeChallenges = new ArrayList<>();
        List<MenuList> menus = homeService.getMenuList();
        model.addAttribute("homeChallenges", homeChallenges);
        model.addAttribute("menus", menus);

        return "home/main";
    }

    @GetMapping("/home/{userIdx}") // home페이지
    public String home(Model model, @PathVariable int userIdx) {

        List<HomeChallenge> homeChallenges = homeService.getHomeChallengeList(userIdx);
        List<MenuList> menus = homeService.getMenuList();
        model.addAttribute("homeChallenges", homeChallenges);
        model.addAttribute("menus", menus);

        return "home/main";
    }




}
