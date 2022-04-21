package slap.programing.onyx.member.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import slap.programing.onyx.member.domain.MemberVO;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    int saveMember(MemberVO memberVO);
    Optional<MemberVO> findMember(@Param("loginId") String loginId, @Param("password") String password);
}
