package kr.co.khBootAdmin.model.payload.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AttachFileRequest {
    private List<MultipartFile> files;
    private String fileTarget;
}
