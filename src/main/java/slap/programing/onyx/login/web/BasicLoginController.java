package slap.programing.onyx.login.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import slap.programing.onyx.login.service.LoginService;
import slap.programing.onyx.member.domain.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class BasicLoginController {

    private final LoginService loginService;
    static final String LOGIN_VIEW_PAGE = "login/";

    @GetMapping()
    public String viewLoginForm() {

        return LOGIN_VIEW_PAGE + "loginForm";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute LoginDTO loginDTO, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {

            return LOGIN_VIEW_PAGE + "loginForm";
        }

        Optional<MemberVO> isLogin = loginService.login(loginDTO.getLoginId(), loginDTO.getPassword());

        if (isLogin.isPresent()) {

            MemberVO memberVO = isLogin.get();
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER, memberVO);

            return LOGIN_VIEW_PAGE + "loginHome";

        } else {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다");

            return LOGIN_VIEW_PAGE + "loginForm";
        }
    }

    @PostMapping("/out")
    public String logOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}