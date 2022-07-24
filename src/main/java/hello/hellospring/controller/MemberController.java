package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.PostSignInReq;
import hello.hellospring.domain.PostUserRes;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("user/sign-up")
    public String signUp(Model model){
        model.addAttribute("postUserRes", new PostUserRes());
        return "user/join";
    }

    @PostMapping("user/sign-up")
    public String create(PostUserRes postUserRes){
        memberService.createUser(postUserRes);
        return "redirect:/home";
    }

    @GetMapping("user/sign-in")
    public String signIn(Model model){
        model.addAttribute("postSignInReq", new PostSignInReq());
        return "user/login";
    }

    @PostMapping("user/sign-in")
    public String signIn(PostSignInReq postSignInReq ) {
       int userIdx = memberService.signIn(postSignInReq);

        return "redirect:/home/"+ userIdx;
    }

}
