package kr.co.khBootAdmin.mapper;

import kr.co.khBootAdmin.model.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {


    // MenuMapper
    List<MenuVO> getListByParentIdIsNull(MenuVO menuVO);

    List<MenuVO> getListByParentIdAndDepth(MenuVO menuVO);


    // UploadFileMapper
    Optional<UploadFile> selectFileById(Long id);

    Optional<UploadFile> selectFileByIdAndFileTarget(UploadFile uploadFile);

    Optional<UploadFile> selectFileAsSaveFileName(String saveFileName);

    void insertFile(UploadFile uploadFile);

    void deleteByFileByIdAndFileTarget(UploadFile uploadFile);

    List<UploadFile> selectFileByBoardId(Long id);


    // FileMapMapper
    void insertFileMap(FileMap fileMap);

    Boolean checkFileMap(FileMap fileMap);


    // UserAuthorityMapper
    void save(UserAuthorityVO userAuthorityVO);


    // BoardMapper
    List<BoardVO> selectBoard(SearchHelper searchHelper);

    int countBoard(SearchHelper searchHelper);

    void boardSave(BoardVO board);

    Optional<BoardVO> boardInfo(Long id);

    void updateBoard(BoardVO board);

    void deleteBoard(Long id);

    void deleteUser(Long userId);

    void deActiveUser(Long userId);

    void activeUser(Long userId);

    void deleteUserAuthorityByUserId(Long userId);

    List<TrackVO> selectCount(TrackVO trackVO);

    List<ArtistVO> followCount(ArtistVO artistVO);

//    int disableUser(@Param("userId") Long userId);
//
//    int enableUser(@Param("userId") Long userId);

    List<UserRoleVO> searchUsers(String keyword);



}
