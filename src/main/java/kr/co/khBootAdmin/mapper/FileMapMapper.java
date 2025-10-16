package kr.co.khBootAdmin.mapper;

import kr.co.khBootAdmin.model.vo.FileMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapMapper {

    void insertFileMap(FileMap fileMap);

    Boolean checkFileMap(FileMap fileMap);

}
