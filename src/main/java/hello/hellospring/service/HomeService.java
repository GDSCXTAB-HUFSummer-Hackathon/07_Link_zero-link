package hello.hellospring.service;

import hello.hellospring.domain.HomeChallenge;
import hello.hellospring.domain.MenuList;
import hello.hellospring.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository){this.homeRepository=homeRepository;}

    public List<MenuList> getMenuList() {return homeRepository.getMenuList();}

    public List<HomeChallenge> getHomeChallengeList(int userIdx) {return homeRepository.getHomeChallengeList(userIdx);}

}
