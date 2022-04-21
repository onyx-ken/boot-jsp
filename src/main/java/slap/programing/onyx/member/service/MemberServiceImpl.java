package slap.programing.onyx.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import slap.programing.onyx.member.domain.MemberVO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public int saveMember(MemberVO memberVO) {

        return memberMapper.saveMember(memberVO);
    }

    @Override
    public Optional<MemberVO> findMember(String loginId, String password) {

        return Optional.ofNullable(memberMapper.findMember(loginId, password).orElse(null));
    }

}
