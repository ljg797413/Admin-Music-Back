package kr.co.khBootAdmin.model.payload.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDeleteRequest {

    private List<Long> id;

}
