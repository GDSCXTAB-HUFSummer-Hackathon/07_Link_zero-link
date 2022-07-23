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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
