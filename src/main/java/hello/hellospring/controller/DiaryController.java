package hello.hellospring.controller;

import hello.hellospring.domain.Diary;
import hello.hellospring.domain.DiaryList;
import hello.hellospring.domain.Hashtag;
import hello.hellospring.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping("diary")
    public String getDiaryList(Model model) {
        List<DiaryList> diaries = diaryService.getDiaryList();
//        List<Hashtag> hashtags = diaryService.getHashTags();
        model.addAttribute("diaries", diaries);
//        model.addAttribute("hashtags", hashtags);
//        for (Hashtag hashtag : hashtags) {
//            System.out.println("hashtag = " + hashtag);
//        }
        for (DiaryList diary : diaries) {
            System.out.println("diary = " + diary.getUserIdx());
            System.out.println("diary = " + diary.getUsername());

        }
        return "diary/diaryList";
    }

    @GetMapping("diary/add")
    public String postForm(Model model) {
        model.addAttribute("diary", new Diary());
        return "diary/uploadDiary";
    }

    @PostMapping("diary/{userIdx}")
    public String save(@ModelAttribute Diary diary, @PathVariable int userIdx, RedirectAttributes redirectAttributes, Model model) {
        Map<String, String> errors = new HashMap<>();

        if (!StringUtils.hasText(diary.getIsPublic())) {
            diary.setIsPublic("N");
        }
        diaryService.save(diary, userIdx);
        return "diary/uploadDiary";
    }

    @GetMapping("diary/calendar/{userIdx}")
    public String getCalendar(@PathVariable int userIdx, @RequestParam(required = false) int year, @RequestParam(required = false) int month, Model model) {
        LocalDate now = LocalDate.now();

        if (year == 0) {
            year = now.getYear();
        }
        if (month == 0) {
            month = now.getMonthValue();
        }
        // 월 가지고 최대일 결정 (2월이면 윤년 test, 윤년이면 최대일배열=dayDataLeapYear)
        int[] dayData = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayDataLeapYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean leapTest = isLeapYear(year);
        int dayMax;
        if (month == 2 && leapTest == true) { //2월이고 윤년
            dayMax = dayDataLeapYear[month - 1];
        } else if (month == 2 && leapTest == false) { //2월이지만 윤년X
            dayMax = dayData[month - 1];
        } else {// 2월 아님
            dayMax = dayData[month - 1];
        }
        List<Integer> dates = diaryService.getCalendar(userIdx, year, month, dayMax);
        model.addAttribute("dates", dates);
        System.out.println("dates = " + dates);
        return "diary/calendar";
    }
    // 윤년 여부 확인
    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        else
            return false;
    }

}
