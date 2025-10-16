package kr.co.khBootAdmin.model.payload.request;

import kr.co.khBootAdmin.model.payload.DeviceInfo;
import kr.co.khBootAdmin.validation.annotation.NullOrNotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {

    @NullOrNotBlank(message = "아이디는 필수 항목입니다.")
    private String username;

    @NotNull(message = "비밀번호는 필수 항목입니다.")
    private String password;

    @Valid
    @NotNull(message = "장치정보는 필수 항목입니다.")
    private DeviceInfo deviceInfo;

}
