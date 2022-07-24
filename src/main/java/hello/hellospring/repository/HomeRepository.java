package hello.hellospring.repository;

import hello.hellospring.domain.*;

import java.util.List;

public interface HomeRepository {
    List<MenuList> getMenuList();

    List<HomeChallenge> getHomeChallengeList(int userIdx);

    Menu getMenu(int menuIdx);

    Restaurant getRestaurant(int menuIdx);

}
