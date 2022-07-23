package hello.hellospring.repository;

import hello.hellospring.domain.DiaryList;
import hello.hellospring.domain.Hashtag;

import java.util.List;

public interface DiaryRepository {
    List<DiaryList> getDiaryList();

//    List<Hashtag> getHashTags();
}
