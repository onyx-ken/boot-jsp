package slap.programing.onyx.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import slap.programing.onyx.member.domain.MemberVO;
import slap.programing.onyx.member.service.MemberService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberService memberService;

    @Override
    public Optional<MemberVO> login(String loginId, String password) {

        return memberService.findMember(loginId, password);
    }
}

