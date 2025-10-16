package kr.co.khBootAdmin.mapper;

import kr.co.khBootAdmin.model.Role;
import kr.co.khBootAdmin.model.vo.UserAuthorityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAuthorityMapper {
    void save(UserAuthorityVO userAuthorityVO);
    List<Role> findRolesByUserId(Long userId); // ← 추가!

}
