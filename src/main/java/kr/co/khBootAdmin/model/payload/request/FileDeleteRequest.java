package kr.co.khBootAdmin.model.payload.request;

import kr.co.khBootAdmin.validation.annotation.NullOrNotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDeleteRequest {

    @NullOrNotBlank(message = "id는 필수입니다.")
    private Long id;
    private String fileTarget;

}
