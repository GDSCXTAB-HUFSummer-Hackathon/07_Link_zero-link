package hello.hellospring.repository;

import hello.hellospring.domain.HomeChallenge;
import hello.hellospring.domain.MenuList;

import java.util.List;

public interface HomeRepository {
    List<MenuList> getMenuList();

    List<HomeChallenge> getHomeChallengeList(int userIdx);
}
