package kr.co.khBootAdmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import kr.co.khBootAdmin.model.vo.MenuVO;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuVO> getListByParentIdIsNull(MenuVO menuVO);

    List<MenuVO> getListByParentIdAndDepth(MenuVO menuVO);
}
