package hello.hellospring.repository;

import hello.hellospring.domain.Diary;
import hello.hellospring.domain.DiaryList;
import hello.hellospring.domain.Hashtag;

import java.util.List;

public interface DiaryRepository {
    List<DiaryList> getDiaryList();

    void save(Diary diary, int userIdx);

}
