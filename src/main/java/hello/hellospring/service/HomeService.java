package hello.hellospring.service;

import hello.hellospring.repository.DiaryRepository;
import hello.hellospring.repository.HomeRepository;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository){this.homeRepository=homeRepository;}
}
