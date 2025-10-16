package kr.co.khBootAdmin.service;

import kr.co.khBootAdmin.model.vo.FileMap;

public interface FileMapService {

    void insertFileMap(FileMap fileMap);

    Boolean checkFileMap(FileMap fileMap);

}
