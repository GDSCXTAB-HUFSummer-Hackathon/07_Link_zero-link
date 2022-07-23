package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  // save 하면 회원이 저장됨
    Optional<Member> findById(Long id);  // findById로 저장소에서 찾아올 수 있음
    Optional<Member> findByName(String name);  // findByName으로 저장소에서 찾아올 수 있음
    List<Member> findAll();  // findAll 하면 모든 회원들 리스트 반환
}
