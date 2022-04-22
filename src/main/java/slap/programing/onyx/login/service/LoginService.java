package slap.programing.onyx.login.service;

import slap.programing.onyx.member.domain.MemberVO;

import java.util.Optional;

public interface LoginService {
    Optional<MemberVO> login(String loginId, String password);
}
