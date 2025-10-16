package kr.co.khBootAdmin.service;

import kr.co.khBootAdmin.model.CustomUserDetails;
import kr.co.khBootAdmin.model.payload.request.BoardDeleteRequest;
import kr.co.khBootAdmin.model.payload.request.BoardRequest;

import java.util.HashMap;

public interface BoardService {

    HashMap<String, Object> selectBoard(BoardRequest searchHelper);

    void saveBoard(CustomUserDetails currentUser, BoardRequest boardRequest);

    HashMap<String, Object> boardInfo(Long id);

    void deleteBoard(BoardDeleteRequest request);

}
