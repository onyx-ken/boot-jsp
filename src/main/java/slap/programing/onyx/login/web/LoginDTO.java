package slap.programing.onyx.login.web;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class LoginDTO {
    @NotEmpty @Size(min = 4, max = 16)
    private String loginId;
    @NotEmpty @Size(min = 8, max = 20)
    private String password;
}