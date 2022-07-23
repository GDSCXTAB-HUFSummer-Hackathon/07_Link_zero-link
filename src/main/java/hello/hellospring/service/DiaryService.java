package hello.hellospring.service;

import hello.hellospring.domain.Diary;
import hello.hellospring.domain.DiaryList;
import hello.hellospring.domain.Hashtag;
import hello.hellospring.repository.DiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }


    public List<DiaryList> getDiaryList() {
        return diaryRepository.getDiaryList();
    }

    public void save(Diary diary, int userIdx) {
        diaryRepository.save(diary, userIdx);
    }

//    public List<Hashtag> getHashTags() {
//        return diaryRepository.getHashTags();
//    }
}
