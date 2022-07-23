package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.PostSignInReq;
import hello.hellospring.domain.PostUserRes;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public void createUser(PostUserRes postUserRes) {
        memberRepository.createUser(postUserRes);
    }

    public int signIn(PostSignInReq postSignInReq) {

        if (memberRepository.checkUser(postSignInReq)) {
            return memberRepository.getUserIdx(postSignInReq.getId());
        } else {
            throw new IllegalStateException("아이디와 비밀번호가 일치하지 않습니다.");
        }


    }
}

