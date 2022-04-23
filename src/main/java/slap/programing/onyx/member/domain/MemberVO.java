package slap.programing.onyx.member.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class MemberVO implements Serializable {
    private Long memId;
    @NotEmpty @Size(min = 4, max = 16)
    private String memLoginId;
    @NotEmpty
    private String memName;
    @NotEmpty @Size(min = 8, max = 20)
    private String memPassword;
}