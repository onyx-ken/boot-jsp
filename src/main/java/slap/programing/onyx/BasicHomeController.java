package slap.programing.onyx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import slap.programing.onyx.login.web.SessionConst;
import slap.programing.onyx.member.domain.MemberVO;

@Controller
public class BasicHomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) MemberVO loginMember, Model model) {

        if(loginMember == null) {
            return "index";
        }
        model.addAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return "login/loginHome";
    }
}