package slap.programing.onyx.member.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import slap.programing.onyx.member.domain.MemberVO;
import slap.programing.onyx.member.service.MemberService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class BasicMemberController {

    private final MemberService memberService;
    
    static final String MEMBER_VIEW_PAGE = "/member/";

    @GetMapping()
    public String main() {
        return "index";
    }


    @GetMapping("/add")
    public String viewAddForm(Model model) {

        model.addAttribute("memberVO", new MemberVO());

        return MEMBER_VIEW_PAGE + "addForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("memberVO") MemberVO memberVO, BindingResult bindingResult)  {

        if (bindingResult.hasErrors()) {

            return MEMBER_VIEW_PAGE + "addForm";
        }

        memberService.saveMember(memberVO);

        return "redirect:/member";
    }
}
