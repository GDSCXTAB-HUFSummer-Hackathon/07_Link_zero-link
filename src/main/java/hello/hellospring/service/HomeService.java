package hello.hellospring.service;

import hello.hellospring.domain.*;
import hello.hellospring.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository){this.homeRepository=homeRepository;}

    public List<MenuList> getMenuList() {return homeRepository.getMenuList();}

    public List<HomeChallenge> getHomeChallengeList(int userIdx) {return homeRepository.getHomeChallengeList(userIdx);}

    public Menu getMenu(int menuIdx) { return homeRepository.getMenu(menuIdx);}

    public Restaurant getRestaurant(int menuIdx) { return homeRepository.getRestaurant(menuIdx);}
}
