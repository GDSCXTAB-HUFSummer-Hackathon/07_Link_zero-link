package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.PostSignInReq;
import hello.hellospring.domain.PostUserRes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    void createUser(PostUserRes postUserRes);

    boolean checkUser(PostSignInReq postSignInReq);

    int getUserIdx(String id);
}
